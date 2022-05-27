package Mazzo;

import java.util.Comparator;

public class CompareByNumber implements Comparator<Carta> {
    @Override
    public int compare(Carta c1, Carta c2) {
        int numberCompare = Integer.compare(c2.numero, c1.numero);

        if(numberCompare != 0)
            return numberCompare;
        else
            return Integer.compare(Carta.getSeedInt(c1.seme), Carta.getSeedInt(c2.seme));
    }
}
