package quadrato;

import javafx.scene.paint.Color;
import luckyclick.Main;

public class QuadratoDivisoDue extends Quadrato {
    public QuadratoDivisoDue(Main master){
        super(master);
        text = "/2";
        backgroundColor = Color.RED;
    }

    @Override
    public int getNewScore(int score){
        return score / 2;
    }
}
