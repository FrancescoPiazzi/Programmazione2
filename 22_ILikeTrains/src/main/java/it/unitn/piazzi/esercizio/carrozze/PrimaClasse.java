package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;

public class PrimaClasse extends Carrozza{
    static int marcaturaPerOra = 200;
    public PrimaClasse(){
        image = new Image(BASE_PATH + "MarcoRonchettiSmall.jpg", 200, 1000, true, false);
        this.setImage(image);
    }

    public String getCode(){
        return "Az";
    }
}
