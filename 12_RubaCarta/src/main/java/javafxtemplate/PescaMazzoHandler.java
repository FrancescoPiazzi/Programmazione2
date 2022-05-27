package javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import mazzo.Mano;
import mazzo.Mazzo;

public class PescaMazzoHandler extends BottoneHandler implements EventHandler<ActionEvent> {
    final Mazzo mazzo;

    PescaMazzoHandler(Mano mano, Mazzo mazzo, GameController controller){
        super(mano, controller);
        this.mazzo = mazzo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!mazzo.isEmpty())
            mano.add(mazzo.pickFirst());
        controller.eliminatePhase();
    }
}
