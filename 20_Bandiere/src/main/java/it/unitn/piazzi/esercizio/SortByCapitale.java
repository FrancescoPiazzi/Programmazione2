package it.unitn.piazzi.esercizio;

import java.util.Comparator;

public class SortByCapitale implements Comparator<Stato> {
    @Override
    public int compare(Stato stato1, Stato stato2) {
        return stato1.capitale.compareTo(stato2.capitale);
    }
}
