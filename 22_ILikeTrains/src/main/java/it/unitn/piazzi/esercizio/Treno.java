package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.carrozze.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Treno extends VBox {
    ArrayList<Carrozza> carrozze;
    String codice;

    Treno(String nome, ArrayList<Carrozza> carrozze){
        HBox carrozzeBox = new HBox();
        MyText nomeTreno = new MyText(nome);

        carrozzeBox.getChildren().addAll(carrozze);
        this.carrozze = carrozze;
        makeCode();
        getChildren().addAll(nomeTreno, carrozzeBox);
    }

    void makeCode(){
        StringBuilder codice = new StringBuilder();
        for(Carrozza c : carrozze)
            codice.append(c.getCode());
        this.codice = codice.toString();
    }
}
