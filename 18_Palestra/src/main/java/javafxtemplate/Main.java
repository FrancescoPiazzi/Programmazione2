package javafxtemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);
    }

    public void generateUI(Stage stage){
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
