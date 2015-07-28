package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by root on 7/28/15.
 */
public class StudentQuestion
{
    StackPane pane = new StackPane();
    GridPane grid = new GridPane();
    Label question = new Label();
    Button team1Button = new Button("Team 1");
    Button team2Button = new Button("Team 2");
    Button shwAnsButton = new Button("Show Answer");
    Label winnerLbl = new Label("Who was right?");
    Stage stage = new Stage();
    Scene scene;

    StudentQuestion(StudentTiles tile, int row, int column)
    {
        pane.setStyle("-fx-background-color: #0000CC");
        pane.getChildren().add(grid);
        grid.add(question, 0, 0, 3, 1);
        grid.add(winnerLbl, 0, 1, 3, 1);
        grid.add(team1Button, 0, 2);
        grid.add(team2Button, 1, 2);
        grid.add(shwAnsButton, 2, 2);

        this.scene = new Scene(pane, 800, 800);
        this.stage.setScene(this.scene);
    }

    void display()
    {
        this.stage.show();
    }
}
