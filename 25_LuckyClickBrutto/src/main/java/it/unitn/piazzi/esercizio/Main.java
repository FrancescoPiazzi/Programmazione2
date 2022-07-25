package it.unitn.piazzi.esercizio;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// 10:00
public class Main extends Application {
    final static int WIN_SCORE = 10;

    GridController controller;

    int vittorie = 0;
    HBox top, bot;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        top = new HBox();
        bot = new HBox();

        controller = new GridController(this);
        updateTop(0, 0);

        Button btnReset = new Button("reset");
        Button btnCheat = new Button("cheat");

        btnReset.setOnAction(e -> controller.newGrid());
        btnCheat.setOnAction(e -> controller.cheat());

        bot.getChildren().addAll(btnReset, btnCheat);

        root.setTop(top);
        root.setCenter(controller.grid);
        root.setBottom(bot);
        // BorderPane.setAlignment(controller.grid, Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Lucky click brutto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void updateTop(int vittorie, int score){
        Text punteggioText = new Text("punteggio: " + score);
        if(score < WIN_SCORE)
            punteggioText.setStroke(Color.RED);
        else if(score > WIN_SCORE)
            punteggioText.setStroke(Color.BLUE);
        else {
            punteggioText.setStroke(Color.GREEN);
            controller.win();
        }

        top.getChildren().clear();
        top.getChildren().addAll(punteggioText, new Text(" vittorie: " + vittorie));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
