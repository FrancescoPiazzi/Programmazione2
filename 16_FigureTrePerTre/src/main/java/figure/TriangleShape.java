package figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TriangleShape extends Polygon {
    TriangleShape(int size, Color c, Color border){
        super(0, size, size/2.0, 0, size, size);
        setFill(c);
        setStroke(border);
    }
}
