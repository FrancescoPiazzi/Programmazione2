package it.unitn.piazzi.esercizio.car;

import it.unitn.piazzi.esercizio.Motore;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public abstract class Car extends VBox {
    static final int SCONTO_IBRIDA = 5000;

    public int id, mese, anno;
    int cilindrata, prezzoBase, prezzoVendita;
    String modello;
    Motore motore;

    public Car(int id, String modello, int cilindrata, Motore motore, int anno, int prezzoBase, int mese) {
        this.id = id;
        this.cilindrata = cilindrata;
        this.prezzoBase = prezzoBase;
        this.anno = anno;
        this.mese = mese;
        this.modello = modello;
        this.motore = motore;
        this.prezzoVendita = prezzoBase;

        applicaSconti();
    }

    protected void applicaSconti(){
        if(motore == Motore.IBRIDO)
            prezzoVendita -= SCONTO_IBRIDA;
    }

    void initVBox(){
        getChildren().addAll(
            new Text("id=" + id),
            new Text("tipologia=" + getClass().getSimpleName()),
            new Text("modello=" + modello),
            new Text("cilindrata=" + cilindrata),
            new Text("motore=" + motore.toString()),
            new Text("anno=" + anno),
            new Text("prezzo base=" + prezzoBase),
            new Text("prezzo vendita=" + prezzoVendita),
            new Text("mese=" + mese)
        );
    }
}
