package escapegame;

import java.util.Random;

public abstract class Enemy extends Palla{
    private int incX, incY;

    Enemy() {
        setNewDirection();
    }

    void setNewDirection(){
        do{
            incX = (new Random().nextInt(3) - 1) * STEP_SIZE;
            incY = (new Random().nextInt(3) - 1) * STEP_SIZE;
        }while(incX==0 && incY==0);
    }

    void update(){
        addX(incX);
        addY(incY);
    }
}
