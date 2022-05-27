package quadrato;

import javafx.scene.paint.Color;
import luckyclick.Main;

import java.util.Random;

public class QuadratoDefault extends Quadrato {
    public QuadratoDefault(Main master) {
        super(master);
        text = Integer.toString(new Random().nextInt(11)*100);
        backgroundColor = Color.WHITE;
    }

    @Override
    public int getNewScore(int score){
        return score + Integer.parseInt(text);
    }
}
