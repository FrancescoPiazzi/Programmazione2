package com.example.javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    int direction;
    int pointer = (int)Math.floor(Math. random()*3);

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        HBox buttons = new HBox();
        HBox figure = new HBox();

        Rectangle quadrato = new Rectangle(50, 50);
        Circle cerchio = new Circle(25);
        Polygon triangolo = new Polygon(0, 0, 50, 0, 25, 50);

        Button btnColor = new Button("Cambia colore");
        Button btnNext = new Button("->");

        buttons.getChildren().addAll(btnColor, btnNext);
        figure.getChildren().addAll(quadrato, cerchio, triangolo);

        buttons.setAlignment(Pos.CENTER);
        figure.setAlignment(Pos.CENTER);

        btnColor.addEventHandler(ActionEvent.ACTION, new ColorListener(figure, this));
        btnNext.addEventHandler(
                ActionEvent.ACTION,
                new DirectionListener((Button)buttons.getChildren().get(1), this)
        );

        mainPane.setBottom(buttons);
        mainPane.setCenter(figure);
        Scene scene = new Scene(mainPane, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}