package com.example.javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {
    int direction = 1;
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

        btnColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pointer += direction;
                if(pointer == -1)
                    pointer = 2;
                if(pointer == 3)
                    pointer = 0;
                System.out.print("Cambio colore a ");
                System.out.println(pointer);

                changeColor((Shape)figure.getChildren().get(pointer));
            }
        });

        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                direction *= -1;
            }
        });

        buttons.getChildren().addAll(btnColor, btnNext);
        figure.getChildren().addAll(quadrato, cerchio, triangolo);
        // Insets i = new Insets(30);
        buttons.setAlignment(Pos.CENTER);
        figure.setAlignment(Pos.CENTER);

        mainPane.setBottom(buttons);
        mainPane.setCenter(figure);
        Scene scene = new Scene(mainPane, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void changeColor(Shape p){
        Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
        p.setFill(c);
    }

    public static void main(String[] args) {
        launch(args);
    }
}