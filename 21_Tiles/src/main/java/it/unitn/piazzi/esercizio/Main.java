package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.tiles.CircleTile;
import it.unitn.piazzi.esercizio.tiles.SquareTile;
import it.unitn.piazzi.esercizio.tiles.Tile;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

// 15:00 -> 17:40
public class Main extends Application implements EventHandler<KeyEvent> {
    final static int MIN = 4, MAX = 10;
    public VBox gameShapes;
    public HBox doneShapes;

    Button btnRiordina;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 700);

        scene.addEventHandler(KeyEvent.KEY_TYPED, this);

        btnRiordina = new Button("Riordina");
        btnRiordina.setOnAction(e -> riordina());
        root.setTop(btnRiordina);
        gameShapes = new VBox();
        root.setCenter(gameShapes);
        gameShapes.setAlignment(Pos.TOP_CENTER);
        doneShapes = new HBox();
        root.setBottom(doneShapes);

        primaryStage.setTitle("Tiles!");
        primaryStage.setScene(scene);
        primaryStage.show();

        int nShapes = promptNumber();
        Random rand = new Random();

        ArrayList<Tile> tiles = new ArrayList<>();
        Tile newTile;
        while (tiles.size() < nShapes/2){
            newTile = new SquareTile(Color.color(
                rand.nextDouble(), rand.nextDouble(), rand.nextDouble()), rand.nextInt(10), this);
            if(!newTile.isContainedIn(tiles))
                tiles.add(newTile);
        }
        while (tiles.size() < nShapes) {
            newTile = new CircleTile(Color.color(
                    rand.nextDouble(), rand.nextDouble(), rand.nextDouble()), rand.nextInt(10), this);
            if(!newTile.isContainedIn(tiles))
                tiles.add(newTile);
        }

        Collections.shuffle(tiles);
        gameShapes.getChildren().addAll(tiles);
    }

    int promptNumber(){
        int n = 10;
        boolean err;
        do{
            err = false;
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setHeaderText("Inserisci un numero tra " + MIN + " e " + MAX);
            try{
                n = Integer.parseInt(textInputDialog.showAndWait().get());
            }
            catch (Exception e) {
                err = true;
            }
        }while(err || n < MIN || n > MAX);

        return n;
    }

    void riordina() {
        ArrayList<Tile> tiles = getGameShapes();
        Collections.sort(tiles);
        setGameShapes(tiles);
    }

    public ArrayList<Tile> getGameShapes(){
        ArrayList<Tile> tiles = new ArrayList<>();
        for(Node n : gameShapes.getChildren())
            tiles.add((Tile)n);
        return tiles;
    }

    public void setGameShapes(ArrayList<Tile> tiles){
        gameShapes.getChildren().clear();
        gameShapes.getChildren().addAll(tiles);
    }

    @Override
    public void handle(KeyEvent e){
        String ch = e.getCharacter().toLowerCase(Locale.ROOT);
        if(ch.equals("r"))
            btnRiordina.fire();
        if("0123456789".contains(ch)){
            int n = Integer.parseInt(ch);
            for(Tile t : getGameShapes())
                if(t.number == n)
                    t.mouseClicked();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
