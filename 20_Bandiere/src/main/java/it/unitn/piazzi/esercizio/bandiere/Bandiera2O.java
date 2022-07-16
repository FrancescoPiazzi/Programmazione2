package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bandiera2O extends Bandiera{
    public Bandiera2O(Color color1, Color color2){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color1);
        gc.fillRect(0, 0, SIZEX, SIZEY/2.0);
        gc.setFill(color2);
        gc.fillRect(0, SIZEY/2.0, SIZEX, SIZEY/2.0);
    }
}
