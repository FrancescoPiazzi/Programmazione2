package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;

public class SecondaClasse extends Carrozza{
    static int marcaturaPerOra = 400;
    public SecondaClasse(){
        image = new Image(BASE_PATH + "MarcoRonchetti.jpg", 200, 1000, true, false);
        this.setImage(image);
    }

    public String getCode(){
        return "Bz";
    }
}
