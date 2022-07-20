package it.unitn.piazzi.esercizio.car;

import it.unitn.piazzi.esercizio.Motore;

public class Utilitaria extends Car{
    static final int SCONTO_PERCENTO = 5;

    public Utilitaria(int id, String modello, int cilindrata, Motore motore, int anno, int prezzoBase, int mese) {
        super(id, modello, cilindrata, motore, anno, prezzoBase, mese);
        initVBox();
    }

    @Override
    protected void applicaSconti(){
        prezzoVendita -= prezzoVendita*SCONTO_PERCENTO/100;
    }
}
