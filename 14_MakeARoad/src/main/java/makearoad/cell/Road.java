package makearoad.cell;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Road extends Cell{
    static final int CIRCLE_RADIUS = 5;
    static final Color CIRCLE_COLOR = Color.LIGHTGRAY;
    static final Color CIRCLE_STROKE_COLOR = Color.YELLOW;

    Circle circle;

    public Road(){
        setBackgroundColor(Color.GRAY);
        circle = generateCircle();
        BorderPane.setAlignment(circle, Pos.CENTER);
    }

    static Circle generateCircle(){
        Circle circle = new Circle(CIRCLE_RADIUS, CIRCLE_COLOR);
        circle.setStroke(CIRCLE_STROKE_COLOR);
        return circle;
    }

    public void addCar(){
        setCenter(makeCar());
    }

    public void removeCar(){
        setCenter(null);
    }
}
