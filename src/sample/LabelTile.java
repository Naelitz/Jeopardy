package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by root on 6/28/15.
 */
public class LabelTile
{
    TextField text = new TextField("Enter Category Here");
    Button submit = new Button("Submit");
    Stage stage = new Stage();
    int rowLocation;
    int columnLocation;
    LabelTile(Main main,Tiles tile, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        Pane pane = new Pane();
        pane.getChildren().add(text);
        pane.getChildren().add(submit);
        text.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 600, 200);
        stage.setScene(scene);
        stage.show();

        submit.setOnAction(e -> {
            tile.text.setText(this.text.getText());
            main.getInfo().categories[column] = this.text.getText();


        });
    }

    LabelTile(Main main,StudentTiles tile, int row, int column)
    {
        this.rowLocation = row;
        this.columnLocation = column;
        Pane pane = new Pane();
        pane.getChildren().add(text);
        pane.getChildren().add(submit);
        text.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 600, 200);
        stage.setScene(scene);
        stage.show();

        submit.setOnAction(e -> {
            tile.text.setText(this.text.getText());
            main.getInfo().categories[column] = this.text.getText();
            this.stage.close();


        });
    }

    void display()
    {
        this.stage.show();
    }
}
