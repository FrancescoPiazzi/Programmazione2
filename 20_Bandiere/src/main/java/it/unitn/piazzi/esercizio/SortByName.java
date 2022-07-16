package it.unitn.piazzi.esercizio;

import java.util.Comparator;

public class SortByName implements Comparator<Stato> {
    @Override
    public int compare(Stato stato1, Stato stato2) {
        return stato1.nome.compareTo(stato2.nome);
    }
}
