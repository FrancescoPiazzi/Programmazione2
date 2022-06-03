package figure;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Objects;

public abstract class GridElement extends VBox implements EventHandler<MouseEvent> {
    static final Color FILL_COLOR = Color.YELLOW;
    static final Color DEFAULT_FILL_COLOR = Color.LIGHTGRAY;
    static final Color BORDER_COLOR = Color.RED;
    static final Color DEFAULT_BORDER_COLOR = Color.LIGHTBLUE;
    static final int SIZE = 100;

    HBox buttons;
    Shape shape;

    GridElement(){
        buttons = new HBox();

        Button btnCancella = new Button("C");
        btnCancella.setOnAction(e -> clear());
        buttons.getChildren().add(btnCancella);

        buttons.setAlignment(Pos.CENTER);

        clear();    // inizializzo la shape
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        getChildren().add(buttons);
    }

    void clear(){
        update(new DefaultShape(SIZE, DEFAULT_FILL_COLOR, DEFAULT_BORDER_COLOR));
    }

    void setTriangle(){
        update(new TriangleShape(SIZE, FILL_COLOR, BORDER_COLOR));
    }

    void setCircle(){
        update(new CircleShape(SIZE/2.0, FILL_COLOR, BORDER_COLOR));
    }

    void update(Shape s){
        getChildren().remove(shape);
        getChildren().add(0, s);
        shape = s;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
        if(actionEvent.getTarget() instanceof Shape)
            clear();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof GridElement)
            if(((GridElement) o).shape instanceof DefaultShape)
                return false;
            else
                return ((GridElement) o).shape.getClass() == shape.getClass();
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape);
    }
}
