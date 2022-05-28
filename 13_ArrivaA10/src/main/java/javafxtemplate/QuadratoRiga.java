package javafxtemplate;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class QuadratoRiga extends QuadratoRigaColonna{
    QuadratoRiga(ArrayList<QuadratoInGriglia> riga, Main main){
        super(riga, main);
        setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void update(boolean recursiveIncrement){
        super.update(recursiveIncrement);
        if(checkWinLoss())
            main.win();
    }
}
