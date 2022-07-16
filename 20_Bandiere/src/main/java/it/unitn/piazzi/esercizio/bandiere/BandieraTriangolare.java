package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BandieraTriangolare extends Bandiera2O{
    public BandieraTriangolare(Color color1, Color color2, Color color3){
        super(color1, color2);
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color3);
        gc.fillPolygon(new double[]{0, SIZEX/4.0, 0}, new double[]{0, SIZEY/2.0, SIZEY}, 3);
    }
}
