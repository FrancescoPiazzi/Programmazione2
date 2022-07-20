package it.unitn.piazzi.esercizio.carrozze;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Carrozza extends ImageView {
    String BASE_PATH = "file:///home/francesco/Programmazione2/22_ILikeTrains/src/main/java/it/unitn/piazzi/esercizio/img/new/";
    Image image;

    public Carrozza(){
    }

    public abstract String getCode();
}
