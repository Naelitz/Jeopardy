package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by david_000 on 6/26/2015.
 */
public class TeacherWindow
{
    BorderPane layout = new BorderPane();
    GridPane pane = new GridPane();
    GridPane center = new GridPane();
    Tiles[][] tiles = new Tiles[6][5];
    public void display(Main main)
    {

        layout.setStyle("-fx-background-color: #000000");

        for(int i = 0; i < 6 ; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                center.add(tiles[i][j] = new Tiles(this, main, i , j), i, j);
            }
        }
        center.setHgap(5);
        center.setVgap(5);

        layout.setCenter(center);
        layout.setTop(pane);
        Label text = new Label("Size of grid?");
        TextField row = new TextField("rows");
        TextField column = new TextField("columns");
        pane.add(text, 0, 0);
        pane.add(row, 0, 1);
        pane.add(column, 0, 2);

        Stage window = new Stage();
        window.setFullScreen(true);


        Scene scene = new Scene(layout, 800, 800);
        //layout.prefWidthProperty().bind(scene.widthProperty());
        //layout.prefHeightProperty().bind(scene.heightProperty());
        center.prefHeight(800);
        center.maxHeight(800);
        center.prefWidth(800);
        center.maxWidth(800);
        window.setScene(scene);
        window.showAndWait();
    }
}
