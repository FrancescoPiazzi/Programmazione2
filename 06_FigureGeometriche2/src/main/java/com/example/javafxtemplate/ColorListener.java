package com.example.javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ColorListener implements EventHandler<ActionEvent> {
    HBox figure;
    Main master;

    ColorListener(HBox figure, Main master){
        this.figure = figure;
        this.master = master;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        /*
         * cambia il colore del quadrato puntato da pointer a un colore casuale
         */
        master.pointer += master.direction;
        if(master.pointer == -1)
            master.pointer = 2;
        if(master.pointer == 3)
            master.pointer = 0;

        changeColor((Shape)figure.getChildren().get(master.pointer));
    }

    private void changeColor(Shape p){
        /*
        * cambia il colore di p a un colore casuale
         */
        Color c = new Color(Math.random(),Math.random(),Math.random(),1.0);
        p.setFill(c);
    }
}
