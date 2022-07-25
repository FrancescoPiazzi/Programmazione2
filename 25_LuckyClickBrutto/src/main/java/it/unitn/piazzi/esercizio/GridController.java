package it.unitn.piazzi.esercizio;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class GridController {
    Main main;
    GridPane grid = new GridPane();

    int size;
    int punteggio = 0;

    GridController(Main main){
        this.main = main;
        this.size = getSize();
        newGrid();
    }

    void newGrid(){
        punteggio = 0;
        main.updateTop(main.vittorie, punteggio);
        grid.getChildren().clear();


        int winPos = new Random().nextInt(size*size);
        int losePos;
        do
            losePos = new Random().nextInt(size*size);
        while(winPos == losePos);

        for (int i=0; i<size*size; i++){
            Tile tile;
            if(i == winPos)
                tile = new WinTile(this);
            else if(i == losePos)
                tile = new LoseTile(this);
            else
                tile = new NumberTile(this);

            tile.addEventHandler(MouseEvent.MOUSE_CLICKED, tile);
            grid.add(tile, i%size, i/size);
        }
    }

    void cheat(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        StringBuilder s = new StringBuilder();
        for(Node n : grid.getChildren()){
            s.append(n.toString()).append(" ");
        }
        alert.setContentText(s.toString());
        alert.showAndWait();
    }

    void addScore(int n){
        punteggio += n;
        main.updateTop(main.vittorie, punteggio);
    }

    void lose(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Hai perso");
        alert.showAndWait();
        System.exit(0);
    }

    void win(){
        main.vittorie++;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Hai vinto!");
        alert.showAndWait();
        newGrid();
        main.updateTop(main.vittorie, punteggio);
    }

    int getSize(){
        int n = 0;
        boolean err;
        do {
            try {
                n = Integer.parseInt(InputDialog.getResponse());
                err = false;
            }
            catch(Exception e){
                err = true;
            }
        }while(err || n < 3 || n > 9);
        return n;
    }
}
