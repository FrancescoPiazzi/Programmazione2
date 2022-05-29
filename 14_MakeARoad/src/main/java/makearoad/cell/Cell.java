package makearoad.cell;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cell extends BorderPane {
    static final int SQUARE_SIZE = 50;

    static final int CAR_HEIGHT = 10, CAR_WIDTH = 20;
    static final Color CAR_COLOR = Color.WHITE;

    public Cell(){
        setMinSize(SQUARE_SIZE, SQUARE_SIZE);
        setStyle("-fx-border-color: black");
        setStyle("-fx-border-width: 2px");
        setStyle("-fx-border-style: solid");
    }

    void setBackgroundColor(Color c){
        setBackground(new Background(new BackgroundFill(c, new CornerRadii(0), new Insets(0))));
    }

    static Rectangle makeCar(){
        return new Rectangle(CAR_HEIGHT, CAR_WIDTH, CAR_COLOR);
    }
}
