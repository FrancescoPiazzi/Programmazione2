package com.example.javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DirectionListener implements EventHandler<ActionEvent> {
    Button btn;
    Main master;

    DirectionListener(Button btn, Main master){
        this.btn = btn;
        this.master = master;
        this.master.direction = 1;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        /*
        * inverte l'attributo direction e aggiorna il testo del bottone
         */
        master.direction *= -1;
        btn.setText(master.direction == 1 ? "->" : "<-");
    }
}
