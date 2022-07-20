package it.unitn.piazzi.esercizio;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MostraTreni{
    VBox treni;
    MostraTreni(Stage stage){
        BorderPane root = new BorderPane();
        treni = new VBox();

        root.setCenter(treni);

        Scene scene = new Scene(root, 1100, 375);
        stage.setTitle("Treniiiih");
        stage.setScene(scene);
        stage.show();
    }

    void updateTreni(ArrayList<Treno> treni){
        this.treni.getChildren().clear();
        this.treni.getChildren().addAll(treni);
    }
}
