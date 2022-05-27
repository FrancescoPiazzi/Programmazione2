package main;

// numero di tentativi prima di riuscire a fare 1+1: 11

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import calcolatrice.Calcolatrice;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){
        Calcolatrice c = new Calcolatrice();

        Scene scene = new Scene(c.root, 200, 200);

        primaryStage.setTitle("Calcolatrice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
