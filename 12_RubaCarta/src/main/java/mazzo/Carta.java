package mazzo;

public class Carta implements Comparable<Carta> {
    Seme seme;
    int numero;

    public Carta(Seme seme, int numero){
        this.seme = seme;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Carta) {
            return this.numero == ((Carta)o).numero;
        }
        else
            return false;
    }

    @Override
    public int hashCode(){
        return numero;
    }

    @Override
    public int compareTo(Carta c){
        int n = Integer.compare(this.numero, c.numero);
        if(n == 0)
            return this.seme.compareTo(c.seme);
        else
            return n;
    }

    @Override
    public String toString(){
        return seme.toString() + numero;
    }
}
