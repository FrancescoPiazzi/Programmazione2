package javafxtemplate.cella;

import javafx.scene.shape.Line;

public class CurvaC extends Cella{
    public CurvaC(){
        getChildren().add(new Line(0, getMinHeight()/2, getMinWidth()/2, getMinHeight()));
    }
}
