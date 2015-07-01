package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by david_000 on 6/26/2015.
 */
public class Tiles extends StackPane
{
    Rectangle box = new Rectangle();
    Label text = new Label();
    Button button = new Button();
    Main main;
    int row;
    int column;
    Tiles(TeacherWindow window, Main main, int row, int column)
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
        this.button.prefWidthProperty().bind(box.widthProperty());
        this.button.prefHeightProperty().bind(box.heightProperty());

        this.box.setBlendMode(BlendMode.LIGHTEN);

        this.button.setOnAction(e -> {
            Questions quest = new Questions(main, row, column);
            quest.display();

        });
    }

    void getLocation()
    {
        System.out.printf("%d and %d", row, column);
    }
}

