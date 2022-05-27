package Mazzo;

import java.util.*;

public class Mazzo{
    LinkedList<Carta> mazzo;

    public Mazzo(){
        mazzo = new LinkedList<>();
        fill();
    }

    public Carta pickFirst(){
        Carta carta;
        if(!mazzo.iterator().hasNext()){
            fill();
        }
        carta = mazzo.iterator().next();
        mazzo.remove(carta);
        return carta;
    }

    public void shuffle(){
        Collections.shuffle(mazzo);
    }

    public void numberOrder(){
        Collections.sort(mazzo, new CompareByNumber());
    }

    public void seedOrder(){
        Collections.sort(mazzo);
    }

    private void fill(){
        for(Seed s : Seed.values()){
            for(int i=1; i<=13; i++){
                mazzo.add(new Carta(s, i));
            }
        }
        shuffle();
    }

    @Override
    public String toString(){
        String str = "";
        for(Carta c : mazzo){
            str += c.toString() + " ";
        }
        return str;
    }
}
