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
    Tiles()
    {
        this.getChildren().addAll(box, text, button);
        button.setOpacity(0);
        box.setWidth(100);
        box.setHeight(100);
        box.setStyle("-fx-fill:#0033CC");
        box.setArcHeight(20);
        box.setArcWidth(20);
    }
}
