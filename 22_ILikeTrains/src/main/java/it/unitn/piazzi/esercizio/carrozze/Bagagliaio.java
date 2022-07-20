package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;

public class Bagagliaio extends Carrozza{
    static int marcaturaPerOra = 400;
    public Bagagliaio(){
        image = new Image(BASE_PATH + "Bagagliaio.jpeg", 175, 100, true, false);
        this.setImage(image);
    }

    public String getCode(){
        return "Dz";
    }
}
