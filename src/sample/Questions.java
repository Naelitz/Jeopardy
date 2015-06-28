package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by root on 6/28/15.
 */
public class Questions
{
    Label text = new Label();
    public void display(Main main)
    {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
