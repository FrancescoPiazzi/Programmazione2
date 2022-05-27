package javafxtemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import mazzo.Mano;

public class ScartaCoppieHandler extends BottoneHandler implements EventHandler<ActionEvent> {
    Button bottonePesca;

    ScartaCoppieHandler(Mano mano, Button bottonePesca, GameController controller){
        super(mano, controller);
        this.bottonePesca = bottonePesca;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!mano.scartaCoppie()){
            // in teoria è sempre true, ma questa parte del codice non lo dovrebbe sapere
            // quindi fa come se non lo sapesse
            boolean initialState = bottonePesca.isDisable();
            bottonePesca.setDisable(false);
            bottonePesca.fire();
            bottonePesca.setDisable(initialState);
        }
        if(mano.isEmpty())
            controller.endGame();
        else {
            controller.nextTurn();
            controller.pickPhase();
        }
    }
}
