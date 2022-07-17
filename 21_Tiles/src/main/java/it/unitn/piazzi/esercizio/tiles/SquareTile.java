package it.unitn.piazzi.esercizio.tiles;

import it.unitn.piazzi.esercizio.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SquareTile extends Tile{
    public SquareTile(Color color, int number, Main main) {
        super(number, main);
        this.shape = new Rectangle(SIZE, SIZE, color);
        addShape();
    }

    public void mouseClicked(){
        number++;
        super.mouseClicked();
    }

    @Override
    boolean isEquivalent(Tile tile){
        if(super.isEquivalent(tile))
            return tile instanceof SquareTile;
        else
            return false;
    }
}
