package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by root on 6/28/15.
 */
public class Questions
{
    TextField text = new TextField("Enter question here.");
    Stage stage = new Stage();
    int rowLocation;
    int columnLocation;
    Questions(Main main, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        Pane pane = new Pane();
        pane.getChildren().add(text);
        text.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    void display()
    {
        this.stage.show();
    }
}
