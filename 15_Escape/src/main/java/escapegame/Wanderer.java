package escapegame;

import javafx.scene.paint.Color;

public class Wanderer extends Striker{
    int iterationsSinceBirth;

    Wanderer() {
        iterationsSinceBirth = 0;
        setFill(Color.LIGHTBLUE);
    }

    @Override
    void update() {
        super.update();
        iterationsSinceBirth++;
        if(iterationsSinceBirth % 5 == 0){
            setNewDirection();
        }
    }
}
