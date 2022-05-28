package javafxtemplate;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public abstract class Quadrato extends Button {
    static final int SQUARE_SIZE = 50;     // la dimensione del lato di un quadrato

    int number;

    void setBackgroundColor(Color c){
        setMinSize(SQUARE_SIZE, SQUARE_SIZE);
        setTextFill(Color.YELLOW);
        setBackground(new Background(new BackgroundFill(c, new CornerRadii(3), new Insets(4))));
    }

    protected void update() {
        setText(Integer.toString(number));
    }

    @Override
    public String toString(){
        return Integer.toString(number);
    }
}
