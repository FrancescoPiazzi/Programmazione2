public class Animale {
    public float peso;
    public int hp, atk;

    Animale(float peso, int hp, int atk){
        System.out.println("chiamato il costruttore 2 di animale");
        this.peso = peso;
        this.hp = hp;
        this.atk = atk;
    }

    Animale(){
        System.out.println("chiamato il costruttore 1 di animale");
        this.peso = 111;
        this.hp = 100;
        this.atk = 8;
    }

    void verso(){
        System.out.println("*Verso generico di animale*");
    }

    void verso(String s){
        System.out.print("Ecco che arriva il verso generico di animale: ");
        System.out.println(s);
    }

    boolean attacca(Animale a){
        if(this.atk >= a.hp)
            return true;
        else{
            a.hp-= this.atk;
            return false;
        }
    }
}
