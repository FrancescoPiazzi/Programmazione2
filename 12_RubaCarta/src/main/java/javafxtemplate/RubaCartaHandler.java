package javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mazzo.Mano;

public class RubaCartaHandler extends BottoneHandler implements EventHandler<ActionEvent> {
    final Mano manoAvversario;

    RubaCartaHandler(Mano mano, Mano manoAvversario, GameController controller){
        super(mano, controller);
        this.manoAvversario = manoAvversario;
    }

    @Override
    public void handle(ActionEvent e){
        mano.add(manoAvversario.removeRandom());
        if(manoAvversario.isEmpty()) {
            // qui so che ha vinto l'altro giocatore, quindi scambio il turno e chiamo la funzione
            // per far vincere l'altro giocatore
            controller.nextTurn();
            controller.endGame();
        }
        else
            controller.eliminatePhase();
    }
}
