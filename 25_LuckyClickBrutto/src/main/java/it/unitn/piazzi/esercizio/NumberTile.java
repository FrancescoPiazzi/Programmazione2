package it.unitn.piazzi.esercizio;

import javafx.scene.text.Text;

import java.util.Random;

public class NumberTile extends Tile{
    int n;

    NumberTile(GridController controller){
        super(controller);
        n = new Random().nextInt(9)+1;
    }

    @Override
    void scopri() {
        super.scopri();
        controller.addScore(n);
        getChildren().add(new Text(Integer.toString(n)));
    }

    @Override
    void nascondi(){
        super.nascondi();
        controller.addScore(-n);
        getChildren().clear();
    }

    @Override
    public String toString(){
        return Integer.toString(n);
    }
}
