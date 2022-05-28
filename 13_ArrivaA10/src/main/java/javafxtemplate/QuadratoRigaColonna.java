package javafxtemplate;

import java.util.ArrayList;

public abstract class QuadratoRigaColonna extends Quadrato{
    final ArrayList<QuadratoInGriglia> array;
    final Main main;

    QuadratoRigaColonna(ArrayList<QuadratoInGriglia> array, Main main){
        this.array = array;
        this.main = main;
        update();
    }

    protected void update(boolean recursiveIncrement){
        int sum = 0;
        for(QuadratoInGriglia q : array) {
            if(recursiveIncrement)
                q.update();
            sum += q.number;
        }
        number = sum;
        super.update();
    }

    boolean checkWinLoss(){
        return number == 10;
    }
}
