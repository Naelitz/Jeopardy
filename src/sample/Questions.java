package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Created by root on 6/28/15.
 */
public class Questions
{
    public TextField text = new TextField("Enter Point Amount");
    public TextField question = new TextField("Enter Question Here");
    public TextField answer = new TextField("Enter Answer Here");
    public Stage stage = new Stage();
    public int rowLocation;
    public int columnLocation;
    public Button apply = new Button("Apply");
    public Main window;
    public Main main;
    Questions(TeacherWindow window, Main main, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        GridPane pane = new GridPane();
        pane.add(text, 0, 0);
        pane.add(apply, 1, 0);
        pane.add(question, 0, 1);
        pane.add(answer, 0, 2);


        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());

        stage.setScene(scene);
        stage.show();

        apply.setOnAction(e -> {
            window.tiles[rowLocation][columnLocation].text.setText(text.getText());
            main.getInfo().points[rowLocation][columnLocation] = text.getText();
            window.tiles[rowLocation][columnLocation].text.setTextFill(Paint.valueOf("#FFAD33"));
            main.getInfo().questions[rowLocation][columnLocation] = question.getText();
            main.getInfo().answers[rowLocation][columnLocation] = answer.getText();

        });
    }

    Questions(StudentWindow window, Main main, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        GridPane pane = new GridPane();
        pane.add(text, 0, 0);
        pane.add(apply, 1, 0);
        pane.add(question, 0, 1);
        pane.add(answer, 0, 2);


        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());

        stage.setScene(scene);
        stage.show();

    }

    void display()
    {
        this.stage.show();
    }


}
