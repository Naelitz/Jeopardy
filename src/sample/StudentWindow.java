package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

/**
 * Created by root on 7/28/15.
 */
public class StudentWindow extends Main
{

        BorderPane layout = new BorderPane();
        //GridPane pane = new GridPane();
        GridPane center = new GridPane();
        StudentTiles[][] tiles;
        Main main;
        Stage stage;
        Button btn = new Button("Set Up");
        public void display(Main main)
        {
            this.main = main;
            // Creates an array of tiles equal to the amount of rows and columns (1 by default)
            this.tiles = new StudentTiles[main.getInfo().rows][main.getInfo().columns];

            // Black background to have blue tiles on black background.
            layout.setStyle("-fx-background-color: #000000");

            // Places all the tiles on the screen
            for(int i = 0; i < main.getInfo().rows ; i++)
            {
                for (int j = 0; j < main.getInfo().columns; j++)
                {
                    // Adds new tile and passes it the row and column location.
                    center.add(this.tiles[i][j] = new StudentTiles(this, main, i, j), i, j);
                    if(j == 0)
                    {
                        this.tiles[i][j].text.setText(main.getInfo().categories[i]);
                    }
                    else
                    {
                        this.tiles[i][j].text.setText(main.getInfo().points[i][j]);
                    }
                    this.tiles[i][j].prefWidthProperty().bind(center.widthProperty().divide(main.getInfo().columns));
                    this.tiles[i][j].prefHeightProperty().bind(center.heightProperty().divide(main.getInfo().rows));
                    //main.tWindow.tiles[j][i].getLocation();

                }
            }
            center.setHgap(5);
            center.setVgap(5);

            layout.setCenter(center);


            Stage window = new Stage();
            window.setFullScreen(true);




            Scene scene = new Scene(layout, 800, 800);
            this.center.prefHeightProperty().bind(layout.heightProperty());
            this.center.maxHeight(800);
            this.center.prefWidthProperty().bind(layout.widthProperty());
            this.center.maxWidth(800);
            window.setScene(scene);
            window.show();
            //fileChooser();

        }

  /*  void fileChooser() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Character Image");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null)
        {
            try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file))))
            {
                for (int i = 0; i < main.getInfo().rows; i++)
                {
                    for (int j = 0; j < main.getInfo().columns; j++)
                    {

                        if (i == 0)
                        {
                            main.getInfo().categories[j]= in.readChar();
                        } else
                        {
                            in.readChar(main.getInfo().questions[i][j]);
                            in.readChar(main.getInfo().answers[i][j]);
                        }
                    }
                }
            }catch(IOException ex){
                ex.printStackTrace();
            };



        }


    }*/
    }


