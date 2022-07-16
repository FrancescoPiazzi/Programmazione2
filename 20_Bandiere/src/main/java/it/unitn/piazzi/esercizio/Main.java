package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.bandiere.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

// 9:30
public class Main extends Application {
    ArrayList<Stato> stati;

    BandiereStage bandiereStage;
    GiocaStage giocaStage;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 250, 150);

        initStati();

        Button btnMostraTutto = new Button("Mostra tutto");
        btnMostraTutto.setOnAction(e -> mostraTutto());
        Button btnGioca = new Button("Gioca");
        btnGioca.setOnAction(e -> gioca());

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btnMostraTutto, btnGioca);

        primaryStage.setTitle("Francesco Piazzi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void initStati(){
        stati = new ArrayList<>();
        stati.add(new Stato("Algeria", "Algiers", new Bandiera2V(Color.GREEN,Color.WHITE)));
        stati.add(new Stato("Armenia", "Yerevan", new Bandiera3O(Color.RED,Color.BLUE, Color.ORANGE)));
        stati.add(new Stato("Chad","N'Djamena", new Bandiera3V(Color.BLUE,Color.YELLOW, Color.RED)));
        stati.add(new Stato("Czech Republic","Prague", new BandieraTriangolare(Color.WHITE, Color.RED, Color.BLUE)));
        stati.add(new Stato("Djibouti","Djibouti", new BandieraTriangolare(Color.CYAN, Color.GREEN, Color.WHITE)));
        stati.add(new Stato("Gabon","Libreville",new Bandiera3V(Color.GREEN, Color.YELLOW, Color.BLUE)));
        stati.add(new Stato("Indonesia","Jakarta", new Bandiera2O(Color.RED, Color.WHITE)));
        stati.add(new Stato("Lithuania","Vilnius",new Bandiera3O(Color.YELLOW, Color.GREEN, Color.RED)));
        stati.add(new Stato("Malta","La Valletta",new Bandiera2V (Color.WHITE, Color.RED)));
        stati.add(new Stato("Ukraine","Kiev",new Bandiera2O(Color.BLUE, Color.YELLOW)));
    }

    void mostraTutto(){
        if(giocaStage!=null && giocaStage.isShowing())
            giocaStage.close();
        if(bandiereStage==null || !bandiereStage.isShowing()) {
            bandiereStage = new BandiereStage(this);
            bandiereStage.show();
        }
    }

    void gioca(){
        if(bandiereStage!=null && bandiereStage.isShowing())
            bandiereStage.close();
        if(giocaStage!=null && giocaStage.isShowing())
            giocaStage.close();
        giocaStage = new GiocaStage(this);
        giocaStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
