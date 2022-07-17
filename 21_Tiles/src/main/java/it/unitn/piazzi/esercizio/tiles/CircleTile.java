package it.unitn.piazzi.esercizio.tiles;

import it.unitn.piazzi.esercizio.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class CircleTile extends Tile {
    public CircleTile(Color color, int number, Main main) {
        super(number, main);
        this.shape = new Circle(SIZE/2.0, color);
        addShape();
    }

    public void mouseClicked(){
        number--;
        super.mouseClicked();
    }

    @Override
    boolean isEquivalent(Tile tile){
        if(super.isEquivalent(tile))
            return tile instanceof CircleTile;
        else
            return false;
    }
}
