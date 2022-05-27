package com.example.javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Mazzo.Mazzo;
import Mazzo.Carta;
import Mazzo.CompareByNumber;

import java.util.Random;

public class GiocoSchifoso extends Application {
    private final int PUNTEGGIO_VITTORIA = 10;

    private VBox riferimento, attuale;
    private HBox ordinamento, punteggio;
    private Text roundVintoPerso;
    private Button btnGioca;

    private Carta cartaRiferimento, cartaAttuale;

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);

        Mazzo mazzo = new Mazzo();
        cartaRiferimento = mazzo.pickFirst();
        ((Text)riferimento.getChildren().get(1)).setText(cartaRiferimento.toString());

        btnGioca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cartaAttuale = mazzo.pickFirst();
                Text punteggioText = (Text)(punteggio.getChildren().get(1));
                int punteggioInt = Integer.parseInt(punteggioText.getText());
                int risultatoMano;
                Text ordinamentoText = (Text)(ordinamento.getChildren().get(1));

                if(new Random().nextInt(2) == 0) {
                    risultatoMano = (-1) * cartaAttuale.compareTo(cartaRiferimento);
                    ordinamentoText.setText("seme");
                }
                else {
                    risultatoMano = (-1) * new CompareByNumber().compare(cartaAttuale, cartaRiferimento);
                    ordinamentoText.setText("numero");
                }

                if(risultatoMano > 0)
                    roundVintoPerso.setText("Mano vinta");
                else if(risultatoMano == 0)
                    roundVintoPerso.setText("Mano pareggiata, in qualche modo");
                else
                    roundVintoPerso.setText("Mano persa");

                punteggioInt += risultatoMano;
                punteggioText.setText(Integer.toString(punteggioInt));
                updateCardText();

                cartaRiferimento = cartaAttuale;
            }
        });
    }

    private void generateUI(Stage primaryStage){
        VBox root = new VBox();
        HBox carte = new HBox();

        riferimento = new VBox();
        riferimento.getChildren().add(new Text("Riferimento"));
        riferimento.getChildren().add(new Text());
        attuale = new VBox();
        attuale.getChildren().add(new Text("Attuale"));
        attuale.getChildren().add(new Text());
        ordinamento = new HBox();
        ordinamento.getChildren().add(new Text("Ordinamento: "));
        ordinamento.getChildren().add(new Text());
        punteggio = new HBox();
        punteggio.getChildren().add(new Text("Punteggio: "));
        punteggio.getChildren().add(new Text("0"));
        roundVintoPerso = new Text();
        btnGioca = new Button("Gioca");

        carte.getChildren().addAll(riferimento, attuale);
        root.getChildren().addAll(carte, ordinamento, roundVintoPerso, punteggio, btnGioca);
        carte.setAlignment(Pos.CENTER);
        ordinamento.setAlignment(Pos.CENTER);
        punteggio.setAlignment(Pos.CENTER);
        riferimento.setAlignment(Pos.CENTER);
        attuale.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);

        root.setStyle("-fx-font-size: 14pt");
        riferimento.setPadding(new Insets(0, 15, 0, 0));
        attuale.setPadding(new Insets(0, 0, 0, 15));
        carte.setPadding(new Insets(0, 0, 20, 0));
        ordinamento.setPadding(new Insets(0, 0, 20, 0));
        punteggio.setPadding(new Insets(0, 0, 20, 0));

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("Gioco schifoso");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCardText(){
        ((Text)attuale.getChildren().get(1)).setText(cartaAttuale.toString());
        ((Text)riferimento.getChildren().get(1)).setText(cartaRiferimento.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}