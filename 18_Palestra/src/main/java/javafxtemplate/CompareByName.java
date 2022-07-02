package javafxtemplate;

import java.util.Comparator;

public class CompareByName implements Comparator<Iscritto> {
    @Override
    public int compare(Iscritto iscritto1, Iscritto iscritto2) {
        int compareCognome = iscritto1.cognome.compareTo(iscritto2.cognome);
        if(compareCognome != 0)
            return compareCognome;
        else
            return iscritto1.nome.compareTo(iscritto2.nome);
    }
}
