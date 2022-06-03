package javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class MovementHandler implements EventHandler<Event> {
    Controller controller;

    MovementHandler(Controller controller){
        this.controller = controller;
    }

    @Override
    public void handle(Event e){
        // la seconda condizione dovrebbe essere sempre vera
        if(e instanceof ActionEvent && e.getTarget() instanceof Button)
            controller.moveAllBlue(((Button)e.getTarget()).getId());
        // se ho premuto un tasto non nel text field provo a spostare una figura rossa
        if(e instanceof KeyEvent)
            if(e.getTarget() instanceof TextField) {
                controller.changeIncrement(((KeyEvent) e).getCharacter());
                e.consume();
            }
            else
                controller.moveRed(((KeyEvent) e).getCharacter());
    }
}
