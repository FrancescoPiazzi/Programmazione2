package javafxtemplate.cella;

import javafx.scene.shape.Line;

public class Dritto extends Cella{
    public Dritto(){
        getChildren().add(new Line(0, getMinHeight()/2, getMinWidth(), getMinHeight()/2));
    }
}
