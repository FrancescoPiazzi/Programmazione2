package it.unitn.piazzi.esercizio.car;

import it.unitn.piazzi.esercizio.Motore;
import javafx.scene.text.Text;

import java.util.Arrays;

public class Sportiva extends Car{
    String[] accessori;
    public Sportiva(int id, String modello, int cilindrata, Motore motore, int anno, int prezzoBase,
                    int mese,String[] accessori) {
        super(id, modello, cilindrata, motore, anno, prezzoBase, mese);
        this.accessori = accessori;
        initVBox();
    }

    @Override
    void initVBox(){
        super.initVBox();
        getChildren().add(new Text("accessori in offerta=" + Arrays.toString(accessori)));
    }
}
