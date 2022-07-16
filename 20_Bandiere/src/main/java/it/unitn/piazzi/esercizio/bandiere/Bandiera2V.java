package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bandiera2V extends Bandiera{
    public Bandiera2V(Color color1, Color color2){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color1);
        gc.fillRect(0, 0, SIZEX/2.0, SIZEY);
        gc.setFill(color2);
        gc.fillRect(SIZEX/2.0, 0, SIZEX/2.0, SIZEY);
    }
}
