package figure;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleShape extends Circle{
    CircleShape(double radius, Color fill, Color border){
        super(radius);
        setFill(fill);
        setStroke(border);
    }
}
