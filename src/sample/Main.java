package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    StackPane stack = new StackPane();
    BorderPane border = new BorderPane();
    ImageView background = new ImageView();
    Image jeopardy = new Image("jeopardy.jpg");
    Top top;
    TeacherWindow tWindow;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        top = new Top(this);
        tWindow = new TeacherWindow();
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Jeopardy");
        background.setImage(jeopardy);
        stack.getChildren().add(background);
        stack.getChildren().add(border);
        border.setTop(top);
        Scene scene = new Scene(stack, 800, 800);
        primaryStage.setScene(scene);
        background.fitWidthProperty().bind(scene.widthProperty());
        background.fitHeightProperty().bind(scene.heightProperty());
        primaryStage.show();

        top.tButton.setOnAction(e -> {
            System.out.println("clicked");
            displayTeacherWindow();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

    void displayTeacherWindow(){ tWindow.display(this);}
}
