package it.unitn.piazzi.esercizio.bandiere;

import javafx.scene.canvas.Canvas;

public abstract class Bandiera extends Canvas {
    static final int SIZEX = 60;
    static final int SIZEY = 42;

    Bandiera(){
        super(SIZEX, SIZEY);
    }
}
