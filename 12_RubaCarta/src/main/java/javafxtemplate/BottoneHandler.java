package javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mazzo.Mano;

public abstract class BottoneHandler implements EventHandler<ActionEvent> {
    final Mano mano;
    final GameController controller;

    BottoneHandler(Mano mano, GameController controller){
        this.mano = mano;
        this.controller = controller;
    }
}
