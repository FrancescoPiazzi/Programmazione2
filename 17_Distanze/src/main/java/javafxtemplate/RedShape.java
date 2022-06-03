package javafxtemplate;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class RedShape extends GameShape{
    Label l;
    RedShape(){
        l = new Label();
        getChildren().add(l);
        shape.setFill(Color.RED);
    }

    void setLabel(String s){
        l.setText(s);
    }
}
