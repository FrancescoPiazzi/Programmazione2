package mazzo;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;
import java.util.Random;


public class Mano extends Mazzo{
    static final int SIZE = 50;
    static final int STARTING_CARDS = 4;

    HBox mazzoVisuale;

    public Mano(HBox mazzoVisuale, Mazzo mazzo){
        this.mazzoVisuale = mazzoVisuale;

        for(int i=0; i<STARTING_CARDS; i++)
            this.add(mazzo.pickFirst());

        updateMazzoVisuale();
    }

    // mi consente di creare mani "virtuali" usato ad es. per scartare le coppie
    private Mano(){ }

    @Override
    public boolean add(Carta c){
        boolean addResult = super.add(c);
        this.sort();
        updateMazzoVisuale();
        return addResult;
    }

    public Carta removeRandom(){
        int n = new Random().nextInt(this.size());
        Carta c = this.get(n);
        this.remove(n);
        updateMazzoVisuale();
        return c;
    }

    public boolean scartaCoppie(){
        Mano carteSenzaCoppie = new Mano();

        for(int i=0; i<this.size(); i++){
            boolean coppia = false;
            for(int j=0; j<this.size(); j++){
                if(i!=j && this.get(i).equals(this.get(j))){
                    coppia = true;
                    break;
                }
            }
            if(!coppia)
                carteSenzaCoppie.add(this.get(i));
        }

        if(carteSenzaCoppie.size() < this.size()){
            this.clear();
            this.addAll(carteSenzaCoppie);
            updateMazzoVisuale();
            return true;
        }
        else
            return false;
    }

    private void updateMazzoVisuale(){
        if(mazzoVisuale == null) {
            System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
            return;
        }

        mazzoVisuale.getChildren().clear();
        this.forEach(carta -> {
            StackPane container = new StackPane();

            Rectangle r = new Rectangle(SIZE, SIZE, Color.LIGHTBLUE);
            r.setStroke(Color.BLACK);

            Text t = new Text(carta.toString());
            t.setTextAlignment(TextAlignment.CENTER);

            container.getChildren().addAll(r, t);

            mazzoVisuale.getChildren().add(container);
        });
    }
}
