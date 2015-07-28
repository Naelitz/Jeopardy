package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * Created by root on 7/28/15.
 */
public class StudentTiles extends StackPane
{
    Rectangle box = new Rectangle();
    Label text = new Label();
    Button button = new Button();
    Main main;
    int row;
    int column;
    StudentTiles(StudentWindow window, Main main, int row, int column)
    {
        this.main = main;
        this.row = row;
        this.column = column;
        this.getChildren().addAll(box, text, button);
        button.setOpacity(0);
        //this.prefWidthProperty().bind(window.center.heightProperty().divide(main.getInfo().columns));
        //this.prefHeightProperty().bind(window.center.heightProperty().divide(main.getInfo().rows));

        this.box.widthProperty().bind(this.widthProperty());
        this.box.heightProperty().bind(this.heightProperty());
        this.box.setStyle("-fx-fill:#0033CC");
        this.box.setArcHeight(20);
        this.box.setArcWidth(20);
        this.button.prefWidthProperty().bind(this.widthProperty());
        this.button.prefHeightProperty().bind(this.heightProperty());

        this.box.setBlendMode(BlendMode.LIGHTEN);

        this.text.setFont(Font.font(64));
        this.text.setStyle("-fx-font-weight: BOLD");
        this.text.setTextFill(Color.WHITE);

        this.button.setOnAction(e -> {
            if (column == 0) {

            } else {
                StudentQuestion sQuestion = new StudentQuestion(this, row, column);
                sQuestion.display();
            }

        });
    }
}
