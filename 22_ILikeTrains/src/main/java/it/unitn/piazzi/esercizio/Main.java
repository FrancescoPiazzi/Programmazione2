package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.carrozze.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

// 10:30
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MostraTreni mostraTreni = new MostraTreni(primaryStage);
        ArrayList<Treno> treni = initTreni();
        mostraTreni.updateTreni(treni);
    }

    ArrayList<Treno> initTreni(){
        ArrayList<Treno> treni = new ArrayList<>();
        ArrayList<Carrozza> carrozze = new ArrayList<>();

        // carrozze.addAll(new Motrice(), new PrimaClasse(), new SecondaClasse());
        carrozze.add(new Motrice());
        carrozze.add(new PrimaClasse());
        carrozze.add(new SecondaClasse());
        treni.add(new Treno("Thomas", carrozze));
        carrozze.clear();

        carrozze.add(new Motrice());
        carrozze.add(new PrimaClasse());
        carrozze.add(new Ristorante());
        carrozze.add(new SecondaClasse());
        treni.add(new Treno("Giuseppe", carrozze));
        carrozze.clear();

        carrozze.add(new Motrice());
        carrozze.add(new SecondaClasse());
        carrozze.add(new SecondaClasse());
        carrozze.add(new Bagagliaio());
        treni.add(new Treno("Mi sto rompendo", carrozze));
        carrozze.clear();
        return  treni;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
