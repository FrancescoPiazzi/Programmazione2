package quadrato;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import luckyclick.Main;

public class QuadratoBomba extends Quadrato {
    int pos;

    public QuadratoBomba(Main master, int pos) {
        super(master);
        this.pos = pos;

        text = "BOOM!";
        backgroundColor = Color.BLUE;
    }

    @Override
    public void handle(ActionEvent e){
        master.bombClicked(pos);
        super.decreaseAttempts();
    }

    @Override
    public void showAndDisable(){
        if(!disabled) {
            super.showAndDisable();
            master.bombClicked(pos);
        }
    }
}
