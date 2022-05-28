package javafxtemplate;

import javafx.scene.paint.Color;

public class QuadratoBlu extends QuadratoInGriglia {
    QuadratoBlu(){
        super();
        setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void update(){
        number++;
        super.update();
    }
}
