package javafxtemplate;

import java.util.Random;

public abstract class QuadratoInGriglia extends Quadrato{
    // Rappresenta un quadrato nella griglia "interna"

    static final int MAX_VALUE = 3;

    QuadratoInGriglia(){
        number = new Random().nextInt(MAX_VALUE+1);
        update();
    }

    @Override
    protected void update(){
        number = adjustNumber(number);
        super.update();
    }

    protected static int adjustNumber(int n){
        if(n > MAX_VALUE)
            n=1;
        if(n < 1)
            n = MAX_VALUE;
        return n;
    }
}
