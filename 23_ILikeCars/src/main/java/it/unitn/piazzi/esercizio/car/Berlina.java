package it.unitn.piazzi.esercizio.car;

import it.unitn.piazzi.esercizio.Motore;

import java.util.Calendar;

public class Berlina extends Car{
    public Berlina(int id, String modello, int cilindrata, Motore motore, int anno, int prezzoBase, int mese) {
        super(id, modello, cilindrata, motore, anno, prezzoBase, mese);
        initVBox();
    }

    @Override
    protected void applicaSconti() {
        int mesi = Calendar.getInstance().get(Calendar.MONTH)+1 - mese;
        if(mesi > Utilitaria.SCONTO_PERCENTO)   // scontoPercento = mesi*1 = mesi
            mesi = Utilitaria.SCONTO_PERCENTO;
        prezzoVendita -= prezzoVendita*mesi/100;
        super.applicaSconti();
    }
}
