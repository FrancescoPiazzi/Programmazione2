package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;

public class Ristorante extends Carrozza{
    static int marcaturaPerOra = 300;
    public Ristorante(){
        image = new Image(BASE_PATH + "ILikeTrains.jpg", 175, 1000, true, false);
        this.setImage(image);
    }

    public String getCode(){
        return "WRz";
    }
}
