package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bandiera3V extends Bandiera{
    public Bandiera3V(Color color1, Color color2, Color color3){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color1);
        gc.fillRect(0, 0, SIZEX/3.0, SIZEY);
        gc.setFill(color2);
        gc.fillRect(SIZEX/3.0, 0, SIZEX/3.0, SIZEY);
        gc.setFill(color3);
        gc.fillRect(SIZEX*2.0/3.0, 0, SIZEX/3.0, SIZEY);
    }
}
