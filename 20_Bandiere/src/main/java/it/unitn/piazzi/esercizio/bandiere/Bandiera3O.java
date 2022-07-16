package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bandiera3O extends Bandiera{
    public Bandiera3O(Color color1, Color color2, Color color3){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color1);
        gc.fillRect(0, 0, SIZEX, SIZEY/3.0);
        gc.setFill(color2);
        gc.fillRect(0, SIZEY/3.0, SIZEX, SIZEY/3.0);
        gc.setFill(color3);
        gc.fillRect(0, SIZEY*2.0/3.0, SIZEX, SIZEY/3.0);
    }
}
