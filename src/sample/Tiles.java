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
    Tiles(TeacherWindow window, Main main, int row, int column)
    {
        this.main = main;
        this.getChildren().addAll(box, text, button);
        button.setOpacity(0);
        box.widthProperty().bind(window.center.widthProperty().divide(main.getInfo().columns));
        box.heightProperty().bind(window.center.heightProperty().divide(main.getInfo().rows));
        box.setStyle("-fx-fill:#0033CC");
        box.setArcHeight(20);
        box.setArcWidth(20);
        button.prefWidthProperty().bind(box.widthProperty());
        button.prefHeightProperty().bind(box.heightProperty());
        button.setOnAction(e -> {
           Questions quest = new Questions(main, row, column);
            quest.display();

        });
    }
}

