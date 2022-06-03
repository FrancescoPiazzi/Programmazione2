package figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DefaultShape extends Rectangle {
    DefaultShape(int size, Color fill, Color border){
        super(size, size);
        setFill(fill);
        setStroke(border);
        setStrokeWidth(3);
    }
}
