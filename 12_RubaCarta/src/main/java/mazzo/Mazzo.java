package mazzo;

import java.util.ArrayList;
import java.util.Collections;

public class Mazzo extends ArrayList<Carta> {
    static final int MAX_CARD_NUMBER = 4;

    public void fill(){
        for(Seme s : Seme.values())
            if(s != Seme.BLACKJACK)
                for(int i=1; i<=MAX_CARD_NUMBER; i++)
                    this.add(new Carta(s, i));
        this.add(new Carta(Seme.BLACKJACK, 0));
    }

    public void shuffle(){
        Collections.shuffle(this);
    }

    public void sort(){
        Collections.sort(this);
    }

    public Carta pickFirst(){
        Carta c = this.get(0);
        this.remove(0);
        return c;
    }

    @Override
    public Mazzo clone(){
        return (Mazzo)super.clone();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Carta c : this)
            s.append(c.toString()).append(" ");
        return s.toString();
    }
}
