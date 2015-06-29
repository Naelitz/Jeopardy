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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by david_000 on 6/26/2015.
 */
public class TeacherWindow
{
    BorderPane layout = new BorderPane();
    GridPane pane = new GridPane();
    GridPane center = new GridPane();
    Tiles[][] tiles;
    Main main;
    Button btn = new Button("Set Up");
    public void display(Main main)
    {
        this.main = main;
        tiles = new Tiles[main.getInfo().rows][main.getInfo().columns];

        layout.setStyle("-fx-background-color: #000000");

        for(int i = 0; i < main.getInfo().columns ; i++)
        {
            for (int j = 0; j < main.getInfo().rows; j++)
            {
                center.add(tiles[i][j] = new Tiles(this, main, i , j), i, j);
            }
        }
        center.setHgap(5);
        center.setVgap(5);

        layout.setCenter(center);
        layout.setTop(pane);
        Label text = new Label("Number of rows?");
        ComboBox row = new ComboBox<Integer>();
        ComboBox column = new ComboBox<>();
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

        Stage window = new Stage();
        //window.setFullScreen(true);


        row.getItems().addAll(1, 2, 3, 4);

        row.setVisibleRowCount(10);

        btn.setOnAction(e -> {
            layout.getChildren().removeAll(center);
            center.getChildren().removeAll();
            main.getInfo().setRows((int)row.getValue());
            System.out.println(main.getInfo().rows);
            this.tiles = new Tiles[main.getInfo().columns][main.getInfo().rows];
            for(int i = 0; i < main.getInfo().columns ; i++)
            {
                for (int j = 0; j < main.getInfo().rows; j++)
                {
                    this.center.add(tiles[i][j] = new Tiles(this, main, i , j), i, j);
                    System.out.println("working");
                }
            }
            layout.getChildren().add(center);
        });



        Scene scene = new Scene(layout, 800, 800);
        center.prefHeight(800);
        center.maxHeight(800);
        center.prefWidth(800);
        center.maxWidth(800);
        window.setScene(scene);
        window.show();
    }
}
