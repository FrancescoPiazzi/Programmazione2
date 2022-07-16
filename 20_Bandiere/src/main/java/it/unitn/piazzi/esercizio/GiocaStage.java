package it.unitn.piazzi.esercizio;

import javafx.application.Preloader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class GiocaStage extends Stage {
    static int NSTATI = 3;

    GridPane gp;
    VBox labels;
    ArrayList<Stato> statiScelti;
    ArrayList<Stato> statiSceltiShuffled;
    ArrayList<TextField> textFields;
    Main main;

    GiocaStage(Main main){
        this.main = main;
        VBox root = new VBox();

        gp = new GridPane();
        labels = new VBox();

        statiScelti = new ArrayList<>();

        // prendo NSTATI a caso
        ArrayList<Stato> statiTutti = (ArrayList<Stato>) main.stati.clone();
        Collections.shuffle(statiTutti);
        for(int i=0; i<NSTATI; i++){
            statiScelti.add(statiTutti.get(i));
        }

        initMainInterface();

        Button btnControlla = new Button("Controlla");
        btnControlla.setOnAction(e -> controlla());

        root.getChildren().addAll(gp, labels, btnControlla);
        Scene scene = new Scene(root);
        setScene(scene);
    }

    /*
       textField.addEventHandler(KeyEvent.KEY_TYPED, e->{
       e.consume();
       if(isValid(e.getCharacter())){
     */

    void initMainInterface(){
        textFields = new ArrayList<>();

        for(int i=0; i<NSTATI; i++){
            gp.add(statiScelti.get(i).bandiera, 0, i);
            TextField textField = new TextField();
            textField.addEventHandler(KeyEvent.KEY_TYPED, e-> {
                e.consume();
                if(isValid(e.getCharacter())) {
                    textField.setDisable(true);
                    textField.setText(statiSceltiShuffled.get(Integer.parseInt(e.getCharacter())).nome);
                }
            });
            textFields.add(textField);
            gp.add(textField, 1, i);
        }
        statiSceltiShuffled = (ArrayList<Stato>) statiScelti.clone();
        Collections.shuffle(statiSceltiShuffled);

        for(int i=0; i<NSTATI; i++){
            labels.getChildren().add(new Text(i + ": " + statiSceltiShuffled.get(i).capitale));
        }
    }

    void controlla(){
        boolean win = true;
        for(int i=0; i<NSTATI && win; i++)
            if(!statiScelti.get(i).nome.equals(textFields.get(i).getText()))
                win = false;
        if(win)
            System.out.println("Hai vinto!");
        else
            System.out.println("Hai perso");
    }

    static boolean isValid(String s){
        int n;
        try {
            n = Integer.parseInt(s);
            return n < NSTATI;
        }
        catch (Exception e){
            return false;
        }
    }
}
