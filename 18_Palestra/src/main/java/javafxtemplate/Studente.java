package javafxtemplate;

public class Studente extends Iscritto{
    Laurea laurea;
    String nomeUni;

    public Studente(String nome, String cognome, String codiceFiscale,
                    int nascitaM, int nascitaY, String nomeUni, Laurea laurea){
        super(nome, cognome, codiceFiscale, nascitaM, nascitaY);
        this.laurea = laurea;
        this.nomeUni = nomeUni;
    }

    @Override
    void setSconto(){
        if(laurea == Laurea.TRIENNALE)
            sconto = 40;
        else {
            sconto = 20;
            super.setSconto();
        }
    }
}
