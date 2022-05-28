package javafxtemplate;

import javafx.scene.paint.Color;

public class QuadratoGrigio extends QuadratoInGriglia {
    QuadratoGrigio(){
        super();
        setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void update(){
        number--;
        super.update();
    }
}
