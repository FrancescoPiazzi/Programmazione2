package javafxtemplate;

import java.util.Comparator;

public class CompareByAge implements Comparator<Iscritto> {
    @Override
    public int compare(Iscritto iscritto1, Iscritto iscritto2) {
        int compareAnno = Integer.compare(iscritto1.nascitaY, iscritto2.nascitaY);
        if(compareAnno != 0)
            return compareAnno;
        else
            return Integer.compare(iscritto1.nascitaM, iscritto2.nascitaM);
    }
}
