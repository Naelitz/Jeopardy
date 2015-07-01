package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by root on 6/28/15.
 */
public class Questions
{
    TextField text = new TextField("Enter Point Amount");
    Stage stage = new Stage();
    int rowLocation;
    int columnLocation;
    Button apply = new Button("Apply");
    Questions(TeacherWindow window, Main main, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        GridPane pane = new GridPane();
        pane.add(text, 0, 0);
        pane.add(apply, 1, 0);
        //pane.getChildren().add(apply);
        //apply.setAlignment(Pos.CENTER_RIGHT);
        //text.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());

        stage.setScene(scene);
        stage.show();

        apply.setOnAction(e -> {
            window.tiles[row][column].text.setText(text.getText());
           // main.getInfo().questions
            main.getInfo().questions[row][column] = text.getText();
        });
    }

    void display()
    {
        this.stage.show();
    }
}
