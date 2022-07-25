package it.unitn.piazzi.esercizio;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Tile extends StackPane implements EventHandler<MouseEvent> {
    static final int SIZE = 75;

    GridController controller;
    boolean scoperta = false;

    Tile(GridController controller){
        this.controller = controller;

       setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
       setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
       setMinSize(SIZE, SIZE);
    }

    @Override
    public void handle(MouseEvent e){
        if(scoperta)
            nascondi();
        else
            scopri();
    }

    void scopri(){
        scoperta = true;
    }

    void nascondi(){
        scoperta = false;
    }
}
