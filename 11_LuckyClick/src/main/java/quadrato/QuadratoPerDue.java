package quadrato;


import javafx.scene.paint.Color;
import luckyclick.Main;

public class QuadratoPerDue extends Quadrato {
    public QuadratoPerDue(Main master) {
        super(master);
        text = "*2";
        backgroundColor = Color.GREEN;
    }

    @Override
    public int getNewScore(int score){
        return score * 2;
    }
}
