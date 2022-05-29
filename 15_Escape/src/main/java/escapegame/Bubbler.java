package escapegame;

import javafx.scene.paint.Color;

import java.util.Random;

public class Bubbler extends Wanderer{
    Bubbler() {
        setFill(Color.DARKBLUE);
    }

    @Override
    void update() {
        super.update();
        if(new Random().nextInt(10) == 0){
            setRadius(getRadius() + getRadius()*0.2);
        }
    }
}
