package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.car.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

// 14:30 -> 18:00 (prendendosela mooolto comoda)
public class Main extends Application {
    BorderPane root;
    Button btnOrder;
    Controller controller;

    EventHandler<ActionEvent> sortIdHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            controller.sortByid();
            btnOrder.setText("id");
            btnOrder.setOnAction(sortMonthHandler);
        }
    };

    EventHandler<ActionEvent> sortMonthHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            controller.sortByMonth();
            btnOrder.setText("mese");
            btnOrder.setOnAction(sortIdHandler);
        }
    };

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        ArrayList<Car> cars = initCars();
        Button btnNext = new Button(">");
        Button btnPrev = new Button("<");
        btnPrev.setDisable(true);   // inizio mostrando il primo elemento, quindi disabilito "a mano" il bottone prev
        btnOrder = new Button("id");
        btnOrder.setOnAction(sortMonthHandler);

        controller = new Controller(this, cars);
        HBox bottom = new HBox();
        bottom.getChildren().addAll(btnOrder, btnPrev, btnNext);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        root.setBottom(bottom);

        btnNext.setOnAction(e -> {btnNext.setDisable(controller.nextCar()); btnPrev.setDisable(false);});
        btnPrev.setOnAction(e -> {btnPrev.setDisable(controller.prevCar()); btnNext.setDisable(false);});

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("I Like Cars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    ArrayList<Car> initCars(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Berlina(1, "B1", 2000, Motore.BENZINA, 2016, 20000, 2));
        cars.add(new Berlina(2, "B2", 1800, Motore.DISEL, 2018, 30000, 6));
        cars.add(new Berlina(3, "B3", 2200, Motore.IBRIDO, 2017, 35000, 4));
        cars.add(new Utilitaria(4, "U1", 1000, Motore.BENZINA, 2018, 10000, 1));
        cars.add(new Utilitaria(5, "U2", 1300, Motore.IBRIDO, 2014, 18000, 2));
        cars.add(new Utilitaria(6, "U3", 1200, Motore.DISEL, 2016, 12000, 6));
        cars.add(new Sportiva(7, "S1", 3000, Motore.BENZINA, 2015, 50000, 3,
                new String[]{"spoiler", "cambio automatico"}));
        cars.add(new Sportiva(8, "S2", 2800, Motore.BENZINA, 2018, 30000, 6,
                new String[]{"tetto a scomparsa", "sedili in pelle"}));
        cars.add(new Sportiva(9, "S3", 3000, Motore.BENZINA, 2013, 65000, 5,
                new String[]{"cromature", "volante ergonomico"}));
        return cars;
    }

    void setCarShown(Car car){
        root.setCenter(car);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
