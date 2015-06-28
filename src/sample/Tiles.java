package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Tiles(TeacherWindow window, Main main)
    {
        this.main = main;
        this.getChildren().addAll(box, text, button);
        button.setOpacity(0);
        box.widthProperty().bind(window.center.widthProperty().divide(6));
        box.heightProperty().bind(window.center.heightProperty().divide(5));
        //box.setWidth(100);
        //box.setHeight(100);
        box.setStyle("-fx-fill:#0033CC");
        box.setArcHeight(20);
        box.setArcWidth(20);

        button.setOnAction(e -> {
           Questions quest = new Questions();
            quest.display(main);

        });
    }
}

