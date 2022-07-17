package it.unitn.piazzi.esercizio.tiles;

import it.unitn.piazzi.esercizio.Main;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;

public abstract class Tile extends StackPane implements Comparable<Tile>{
    static final int SIZE = 50;
    static final int MAX_NUMBER = 9;

    EventHandler<MouseEvent> eventHandler;

    Main main;
    Shape shape;
    Text text;
    public int number;
    
    Tile(int number, Main main){
        this.number = number;
        this.main = main;
        text = new Text();

        eventHandler = e -> mouseClicked();
        addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void mouseClicked(){
        // aggiusto il numero modificato nelle sottoclassi
        if(number > MAX_NUMBER)
            number = 0;
        else if(number < 0)
            number = MAX_NUMBER;
        text.setText(Integer.toString(number));

        // elimino l'eventuale coppia formata
        boolean coppia = false;
        for(Tile t : main.getGameShapes()){
            // this è incluso in tiles, quindi controllo di non controllarlo con se stesso
            if(this != t && this.isEquivalent(t)){
                t.disable();
                this.disable();
                coppia = true;
                break;  // appena elimino una coppia è inutile proseguire
            }
        }

        ObservableList<Node> tiles = main.gameShapes.getChildren();
        // se non ho eliminato nessuna coppia sposto la figura cliccata
        if(!coppia){
            tiles.remove(this);
            if(this instanceof SquareTile)
                tiles.add(0, this);
            else
                tiles.add(tiles.size(), this);
        }
    }

    void disable(){
        main.gameShapes.getChildren().remove(this);
        this.removeEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        main.doneShapes.getChildren().add(this);
    }

    void addShape(){
        text.setText(Integer.toString(number));
        getChildren().addAll(shape, text);
    }

    public boolean isContainedIn(ArrayList<? extends Tile> array){
        for(Tile n : array)
            if(this.isEquivalent(n))
                return true;
        return false;
    }
    
    boolean isEquivalent(Tile tile){
        return number == tile.number;
    }

    @Override
    public int compareTo(Tile tile) {
        return number-tile.number;
    }

    @Override
    public String toString(){
        return getClass().getName() + number;
    }
}
