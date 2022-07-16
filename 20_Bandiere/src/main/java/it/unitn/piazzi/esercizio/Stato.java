package it.unitn.piazzi.esercizio;

import it.unitn.piazzi.esercizio.bandiere.Bandiera;

public class Stato {
    Bandiera bandiera;
    String capitale, nome;

    public Stato(String nome, String capitale, Bandiera bandiera) {
        this.bandiera = bandiera;
        this.nome = nome;
        this.capitale = capitale;
    }
}
