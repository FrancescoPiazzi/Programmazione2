public class Cavallo extends Animale{
    Cavallo(){
        System.out.println("chiamato il costruttore 1 di cavallo");
    }

    Cavallo(float peso, int hp, int atk){
        // super(peso, hp, atk);   // deve essere la prima riga del metodo se c'è
        System.out.println("chiamato il costruttore 2 di cavallo");
    }

    @Override
    void verso(){
        System.out.println("*Inserisci qui battuta scontata su Moro*");
    }

    @Override
    void verso(String s){
        System.out.print("Guardate sono un cavallo che parla: ");
        System.out.println(s);
    }

    @Override
    boolean attacca(Animale a){
        if(this.atk >= a.hp)
            return true;
        else{
            a.hp-= this.atk;
            return false;
        }
    }
}
