public class Ripasso {
    public static void main(String[] args){
        Animale c1 = new Cavallo(100, 200, 20);  // posso farlo perchè tutti i cavalli sono animali
        System.out.println("----\n");
        Cavallo c2 = new Cavallo(100, 200, 20);  // ovvio
        System.out.println("----\n");
        // Cavallo c3 = new Animale(100, 200, 30);  // non posso perchè non tutti gli animali sono cavalli
        Cavallo c3 = new Cavallo();
        System.out.println("----\n");
        Animale cosoStrano = new Animale();
        System.out.println("----\n");
        Animale cosoStranoOp = new Animale(1000, 10000, 3000);
        System.out.println("----\n");

        // entrambe vengono trattati come cavalli
        c1.verso("hahaha");
        c2.verso("hihihihi");
        c2.attacca(c1);
        cosoStrano.attacca(c2);
        cosoStranoOp.attacca(c3);
    }
}
