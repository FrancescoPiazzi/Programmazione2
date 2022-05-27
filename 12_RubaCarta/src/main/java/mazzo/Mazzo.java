package mazzo;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
    static final int MAX_CARD_NUMBER = 4;

    ArrayList<Carta> carte;

    public Mazzo(){
        carte = new ArrayList<>();
    }

    public void fill(){
        for(Seme s : Seme.values())
            if(s != Seme.BLACKJACK)
                for(int i=1; i<=MAX_CARD_NUMBER; i++)
                    carte.add(new Carta(s, i));
        carte.add(new Carta(Seme.BLACKJACK, 0));
    }

    public void shuffle(){
        Collections.shuffle(carte);
    }

    public void sort(){
        Collections.sort(carte);
    }

    public Carta pickFirst(){
        Carta c = carte.get(0);
        carte.remove(0);
        return c;
    }

    public boolean isEmpty(){
        return carte.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Carta c : carte)
            s.append(c.toString()).append(" ");
        return s.toString();
    }
}
