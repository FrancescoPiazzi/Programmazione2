package javafxtemplate;

import java.util.Objects;

public class Iscritto {
    static final int PREZZO_BASE = 1000;

    String nome, cognome, codiceFiscale;
    int nascitaM, nascitaY;
    int sconto;

    public Iscritto(String cognome, String nome, String codiceFiscale, int nascitaM, int nascitaY) {
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.nascitaM = nascitaM;
        this.nascitaY = nascitaY;

        setSconto();
    }

    void setSconto(){
        if(nascitaY < 1968)
            sconto = 35;
    }

    public int prezzoFinale(){
        return PREZZO_BASE - PREZZO_BASE*sconto/100;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + nascitaM + " " + nascitaY + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Iscritto iscritto = (Iscritto) o;
        return nascitaM == iscritto.nascitaM && nascitaY == iscritto.nascitaY &&
                nome.equals(iscritto.nome) && cognome.equals(iscritto.cognome) &&
                codiceFiscale.equals(iscritto.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, codiceFiscale, nascitaM, nascitaY);
    }
}
