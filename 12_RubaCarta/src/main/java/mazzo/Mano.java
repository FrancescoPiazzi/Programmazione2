package mazzo;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafxtemplate.GameController;

import java.util.ArrayList;
import java.util.Random;


public class Mano extends Mazzo{
    static final int SIZE = 50;
    static final int STARTING_CARDS = 4;

    HBox mazzoVisuale;

    public Mano(HBox mazzoVisuale, Mazzo mazzo){
        for(int i=0; i<STARTING_CARDS; i++)
            this.carte.add(mazzo.pickFirst());

        this.mazzoVisuale = mazzoVisuale;

        updateMazzoVisuale();
    }

    public void add(Carta c){
        carte.add(c);
        this.sort();
        updateMazzoVisuale();
    }

    public Carta removeRandom(){
        int n = new Random().nextInt(carte.size());
        Carta c = carte.get(n);
        carte.remove(n);
        updateMazzoVisuale();
        return c;
    }

    public boolean scartaCoppie(){
        ArrayList<Carta> carteSenzaCoppie = new ArrayList<>();

        for(int i=0; i<carte.size(); i++){
            boolean coppia = false;
            for(int j=0; j<carte.size(); j++){
                if(i!=j && carte.get(i).equals(carte.get(j))){
                    coppia = true;
                    break;
                }
            }
            if(!coppia)
                carteSenzaCoppie.add(carte.get(i));
        }

        if(carteSenzaCoppie.size() < carte.size()){
            carte = carteSenzaCoppie;
            updateMazzoVisuale();
            return true;
        }
        else
            return false;
    }

    private void updateMazzoVisuale(){
        mazzoVisuale.getChildren().remove(0, mazzoVisuale.getChildren().size());
        carte.forEach(carta -> {
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
