package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * Created by david_000 on 6/25/2015.
 */
public class Top extends HBox
{
    ImageView iv1 = new ImageView();
    ImageView iv2 = new ImageView();
    Image student = new Image("playbutton.png");
    Image teacher = new Image("teacherbutton.png");

    StackPane stack1 = new StackPane();
    StackPane stack2 = new StackPane();

    Button sButton = new Button();
    Button tButton = new Button();

    Main main;

    Top(Main main)
    {
        this.main = main;
        this.prefWidthProperty().bind(main.background.fitWidthProperty());
        iv1.setImage(student);
        iv2.setImage(teacher);
        //iv2.OnMouseClicked(main.tWindow.display(main));
        this.getChildren().add(stack1);
        this.getChildren().add(stack2);

        stack1.getChildren().add(iv1);
        stack1.getChildren().add(sButton);
        sButton.setOpacity(0);
        stack2.getChildren().add(iv2);
        stack2.getChildren().add(tButton);
        tButton.prefWidthProperty().bind(iv2.fitWidthProperty());
        tButton.prefHeightProperty().bind(iv2.fitHeightProperty());
        tButton.setOpacity(0);

    }
}
