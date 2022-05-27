package Mazzo;

public class Carta implements Comparable<Carta>{
    public Seed seme;
    public int numero;

    public Carta(Seed s, int i) {
        seme = s;
        // l'asso corrisponde a 14 per semplificare l'ordinamento
        if(i == 1)
            numero = 14;
        else
            numero = i;
    }

    @Override
    public int compareTo(Carta carta){
        int seedCompare = Integer.compare(Carta.getSeedInt(this.seme), Carta.getSeedInt(carta.seme));

        if(seedCompare != 0)
            return seedCompare;
        else
            return Integer.compare(carta.numero, this.numero);
    }

    @Override
    public String toString() {
        return getSeedStr() + getNumberStr();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Carta)){
            return false;
        }
        else{
            Carta c = (Carta)o;
            return c.numero == this.numero && c.seme.equals(this.seme);
        }
    }

    @Override
    public int hashCode(){
        int i=0;
        for(Seed s : Seed.values()){
            if(s == seme)
                return numero + 14*i;
            i++;
        }
        return -1;
    }

    private String getSeedStr(){
        if(seme == Seed.CUORI)
            return "♥";
        if(seme == Seed.QUADRI)
            return "♦";
        if(seme == Seed.FIORI)
            return "♣";
        if(seme == Seed.PICCHE)
            return "♠";
        return "seme non valido";
    }

    private String getNumberStr(){
        if(numero >= 1 && numero <= 10)
            return Integer.toString(numero);
        else if(numero == 11)
            return "J";
        else if(numero == 12)
            return "Q";
        else if(numero == 13)
            return "K";
        else if(numero == 14)
            return "A";
        else
            return "numero non valido";
    }

    static int getSeedInt(Seed seme){
        if(seme == Seed.CUORI)
            return 1;
        if(seme == Seed.QUADRI)
            return 2;
        if(seme == Seed.FIORI)
            return 3;
        if(seme == Seed.PICCHE)
            return 4;
        return -1;
    }
}
