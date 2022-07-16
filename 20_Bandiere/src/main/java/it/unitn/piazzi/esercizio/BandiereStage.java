package it.unitn.piazzi.esercizio;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BandiereStage extends Stage {
    GridPane gp;
    Main main;

    BandiereStage(Main main){
        VBox root = new VBox();
        this.main = main;
        gp = new GridPane();
        gp.setAlignment(Pos.TOP_CENTER);

        updateBandiere();

        Button btnOrdinaNome = new Button("Ordina per stato");
        btnOrdinaNome.setOnAction(e -> {main.stati.sort(new SortByName()); updateBandiere();});
        Button btnOrdinaCapitale = new Button("Ordina per capitale");
        btnOrdinaCapitale.setOnAction(e -> {main.stati.sort(new SortByCapitale()); updateBandiere();});

        root.getChildren().addAll(gp, new HBox(btnOrdinaNome, btnOrdinaCapitale));

        Scene scene = new Scene(root);
        setScene(scene);
    }

    void updateBandiere(){
        gp.getChildren().clear();

        int i=0;
        for(Stato s : main.stati){
            gp.add(s.bandiera, 0, i);
            gp.add(new Text(s.nome), 1, i);
            gp.add(new Text(s.capitale), 2, i);
            i++;
        }
    }
}
