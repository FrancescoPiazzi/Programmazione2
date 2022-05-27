package stuff;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Objects;
import java.util.Random;

public class Figura extends StackPane{
    private static final Color disabledColor = Color.WHITE;
    private static final int size = 60;

    private Shape oggetto;
    private final Color color;

    public Figura (EventHandler<MouseEvent> handler, int x, int y) {
        super();
        Random r = new Random ();

        switch (r.nextInt(3)) {
            case 0:
                oggetto = new Circle(size/2.0);
                break;
            case 1:
                oggetto = new Rectangle(size, size);
                break;
            case 2:
                oggetto = new Polygon(0, 0, size, 0, size/2.0, size);
                break;
            default:
                break;
        }

        color = (x+y)%2 == 0 ? Color.GREEN : Color.RED;
        oggetto.setFill(disabledColor);
        oggetto.setStroke(Color.BLACK);

        this.getChildren().add(oggetto);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    public void change() {
        oggetto.setFill(oggetto.getFill().equals(disabledColor) ? color : disabledColor);
    }

    public void reset(){
        oggetto.setFill(disabledColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;

        if (this.oggetto.getClass()!= figura.oggetto.getClass()) return false;
        // su questo ne possiamo discutere ma ok
        return oggetto.getFill().equals((figura.oggetto.getFill()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(oggetto);
    }
}
