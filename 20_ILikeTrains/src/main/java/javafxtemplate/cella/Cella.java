package javafxtemplate.cella;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Cella extends Pane {
    final static int SIZEX = 130;
    final static int SIZEY = 100;

    public Cella(){
        setMinWidth(SIZEX);
        setMinHeight(SIZEY);

        setBorder(new Border(new BorderStroke(
                Color.LIGHTBLUE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)
        ));
    }
}
