package javafxtemplate;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class QuadratoColonna extends QuadratoRigaColonna{
    QuadratoColonna(ArrayList<QuadratoInGriglia> colonna, Main main){
        super(colonna, main);
        setBackgroundColor(Color.RED);
    }

    @Override
    protected void update(boolean recursiveIncrement){
        super.update(recursiveIncrement);
        if(checkWinLoss())
            main.lose();
    }
}
