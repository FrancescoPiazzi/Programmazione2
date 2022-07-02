package javafxtemplate;

public class Atleta extends Iscritto{
    LivelloAtleta livelloAtleta;
    public Atleta(String cognome, String nome, String codiceFiscale,
                  int nascitaM, int nascitaY, LivelloAtleta livelloAtleta) {
        super(cognome, nome, codiceFiscale, nascitaM, nascitaY);
        this.livelloAtleta = livelloAtleta;
    }

    @Override
    void setSconto(){
        if(livelloAtleta == LivelloAtleta.INTERNAZIONALE)
            sconto = 50;
        else{
            sconto = 30;
            super.setSconto();
        }
    }

    @Override
    public String toString(){
        return super.toString() + livelloAtleta;
    }
}
