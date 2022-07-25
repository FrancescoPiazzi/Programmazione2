package it.unitn.piazzi.esercizio;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {
    final static int SIZE_X = 700, SIZE_Y = 600;

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        VBox persone = new VBox();
        VBox personeTop = new VBox();
        VBox personeBot = new VBox();

        VBox macchine = new VBox();
        VBox macchineTop = new VBox();
        VBox macchineBot = new VBox();

        TextArea txtPersone = new TextArea();
        Button btnMixPersone = new Button("Mescola");
        Button btnSortPersone = new Button("Ordina");
        Button btnCountPersone = new Button("Conta");
        Button btnSortByYearPersone = new Button("Ordina per anno");
        Button btnNewPerson = new Button("Nuova persona");

        TextArea txtCars = new TextArea();
        Button btnMixCars = new Button("Mescola");
        Button btnSortCars = new Button("Ordina");
        Button btnCountCar = new Button("Conta");
        Button btnSortByYearCars = new Button("Ordina per anno");
        Button btnNewCar = new Button("Nuova auto");

        txtPersone.setMinSize(SIZE_X/2.0, 150);
        txtCars.setMinSize(SIZE_X/2.0, 150);

        personeTop.getChildren().addAll(txtPersone, btnMixPersone, btnSortPersone, btnCountPersone, btnSortByYearPersone);
        personeBot.getChildren().add(btnNewPerson);
        persone.getChildren().addAll(personeTop, personeBot);

        macchineTop.getChildren().addAll(txtCars, btnMixCars, btnSortCars, btnCountCar, btnSortByYearCars);
        macchineBot.getChildren().add(btnNewCar);
        macchine.getChildren().addAll(macchineTop, macchineBot);

        root.getChildren().addAll(persone, macchine);

        persone.setMinHeight(SIZE_Y);
        personeTop.setMinHeight(SIZE_Y/2.0);
        personeBot.setMinHeight(SIZE_Y/2.0);

        macchine.setMinHeight(SIZE_Y);
        macchineTop.setMinHeight(SIZE_Y/2.0);
        macchineBot.setMinHeight(SIZE_Y/2.0);

        personeTop.setAlignment(Pos.TOP_RIGHT);
        personeBot.setAlignment(Pos.BOTTOM_RIGHT);
        macchineTop.setAlignment(Pos.TOP_LEFT);
        macchineBot.setAlignment(Pos.BOTTOM_LEFT);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, SIZE_X, SIZE_Y);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
