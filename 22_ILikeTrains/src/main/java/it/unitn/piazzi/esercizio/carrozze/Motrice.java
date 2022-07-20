package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;

public class Motrice extends Carrozza{
    static int marcaturaPerOra = 0;
    public Motrice(){
        image = new Image(BASE_PATH + "TrenoPerDavvero.jpg", 110, 1000, true, false);
        this.setImage(image);
    }

    public String getCode(){
        return "Loco";
    }
}
