package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by david_000 on 6/26/2015.
 */
public class TeacherWindow
{
    public static void display(Main main)
    {

        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-background-color: #000000");
        GridPane center = new GridPane();
        for(int i = 0; i < 6 ; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                center.add(new Tiles(), i, j);
            }
        }
        center.setHgap(5);
        center.setVgap(5);

        layout.setCenter(center);

        Stage window = new Stage();


        Scene scene = new Scene(layout, 800, 800);
        window.setScene(scene);
        window.showAndWait();
    }
}
