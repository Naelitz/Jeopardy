package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by david_000 on 6/26/2015.
 */
public class TeacherWindow extends Main
{
    BorderPane layout = new BorderPane();
    GridPane pane = new GridPane();
    GridPane center = new GridPane();
    GridPane bottom = new GridPane();
    TextField title = new TextField("Enter File Name Here");
    Tiles[][] tiles;
    Main main;
    Button btn = new Button("Set Up");
    Button saveBtn = new Button("Save");
    public void display(Main main)
    {
        this.main = main;
        // Creates an array of tiles equal to the amount of rows and columns (1 by default)
        this.tiles = new Tiles[main.getInfo().rows][main.getInfo().columns];

        // Black background to have blue tiles on black background.
        layout.setStyle("-fx-background-color: #000000");

        // Places all the tiles on the screen
        for(int i = 0; i < main.getInfo().columns ; i++)
        {
            for (int j = 0; j < main.getInfo().rows; j++)
            {
                // Adds new tile and passes it the row and column location.
                center.add(this.tiles[i][j] = new Tiles(this, main, i , j), i, j);
                tiles[i][j].getLocation();
            }
        }
        center.setHgap(5);
        center.setVgap(5);

        layout.setCenter(center);
        // Sets up top menu bar to choose size of question grid. Then devides nodes into 4 equal sizes
        // based on the width of the pane.
        layout.setTop(pane);
        Label text = new Label("Number of rows?");
        ComboBox row = new ComboBox<Integer>();
        ComboBox column = new ComboBox<Integer>();
        Label text2 = new Label("Number of columns?");
        pane.add(text, 0, 0);
        text.prefWidthProperty().bind(pane.widthProperty().divide(5));
        pane.add(row, 1, 0);
        row.prefWidthProperty().bind(pane.widthProperty().divide(5));
        pane.add(text2, 2, 0);
        text2.prefWidthProperty().bind(pane.widthProperty().divide(5));
        pane.add(column, 3, 0);
        column.prefWidthProperty().bind(pane.widthProperty().divide(5));
        pane.add(btn, 4, 0);
        btn.prefWidthProperty().bind(pane.widthProperty().divide(5));
        pane.setStyle("-fx-background-color: #B2B2CC");

        layout.setBottom(bottom);
        bottom.add(title, 0, 0);
        title.setStyle("-fx-background-color: #6666FF");
        bottom.add(saveBtn, 1, 0);
        saveBtn.setStyle("-fx-background-color: #6666FF");
        saveBtn.setPrefWidth(125);


        Stage window = new Stage();
        window.setFullScreen(true);


        row.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        column.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);

        row.setVisibleRowCount(10);

        btn.setOnAction(e -> {
            main.getInfo().update((int) row.getValue(), (int) column.getValue());
            this.layout.getChildren().removeAll(center);
            this.center.getChildren().removeAll();
            main.getInfo().setRows((int) row.getValue());
            main.getInfo().setColumns((int) column.getValue());
            System.out.println(main.getInfo().rows);
            this.tiles = new Tiles[main.getInfo().rows][main.getInfo().columns];
            for (int i = 0; i < main.getInfo().rows; i++) {
                for (int j = 0; j < main.getInfo().columns; j++) {
                    this.center.add(this.tiles[i][j] = new Tiles(this, main, i, j), i, j);
                    this.tiles[i][j].prefWidthProperty().bind(center.widthProperty().divide(main.getInfo().columns));
                    this.tiles[i][j].prefHeightProperty().bind(center.heightProperty().divide(main.getInfo().rows));
                    this.tiles[i][j].getLocation();
                    System.out.println("working");
                }
            }
            layout.getChildren().add(center);


        });

        saveBtn.setOnAction(e -> {
            BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter( new FileWriter( title.getText() + ".txt"));
                //writer.write( yourstring);

                for (int i = 0; i < main.getInfo().rows; i++)
                {
                    for (int j = 0; j < main.getInfo().columns; j++)
                    {
                        writer.write(tiles[i][j].text.getText());
                        if (i == 0)
                        {
                            writer.write(main.getInfo().categories[j]);
                        } else
                        {
                            writer.write(main.getInfo().questions[i][j]);
                            writer.write(main.getInfo().answers[i][j]);
                        }
                    }
                }

            }
            catch ( IOException d)
            {
                d.printStackTrace();
            }
            finally
            {
                try
                {
                    if ( writer != null)
                        writer.close( );
                }
                catch ( IOException d)
                {
                }
            }


        });



        Scene scene = new Scene(layout, 800, 800);
        this.center.prefHeightProperty().bind(layout.heightProperty());
        this.center.maxHeight(800);
        this.center.prefWidthProperty().bind(layout.widthProperty());
        this.center.maxWidth(800);
        window.setScene(scene);
        window.show();
    }
}
