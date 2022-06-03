package javafxtemplate;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;

import java.util.Random;

public abstract class GameShape extends StackPane {
    static final int SIZE = 20;
    static final int MIN_DISTANCE = 50;

    Shape shape;
    float x, y;

    GameShape(){
        switch (new Random().nextInt(3)){
            case 0:
                shape = new Rectangle(SIZE * Math.sqrt(2), SIZE * Math.sqrt(2));
                break;
            case 1:
                shape = new Circle(SIZE);
                break;
            case 2:
                shape =  new Polygon(
                        1/2.0 * SIZE, 0,
                        3/2.0 * SIZE, 0,
                        SIZE*2, SIZE,
                        3/2.0 * SIZE, SIZE*2,
                        1/2.0 * SIZE, SIZE*2,
                        0, SIZE);
        }
        getChildren().add(shape);
        setMaxSize(SIZE, SIZE);
    }

    void setCoords(float x, float y){
        this.x = x;
        this.y = y;
        updatePosition();
    }

    void move(float x, float y){
        this.x += x;
        this.y += y;
        updatePosition();
    }

    void updatePosition(){
        setTranslateX(x);
        setTranslateY(y);
    }

    boolean isColliding(GameShape gameShape){
        // ritorna true se il centro della shape è a meno di MIN_DISTANCE pixel dal centro di gameShape false altrimenti
        float x1 = x+SIZE, x2 = gameShape.x+SIZE;
        float y1 = y+SIZE, y2 = gameShape.y+SIZE;

        double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        return distance < MIN_DISTANCE;
    }

    boolean isColliding(){
        // ritorna true se il centro della shape è a mendo di MIN_DISTANCE da una parete del gioco
        float x = this.x+SIZE, y = this.y+SIZE;
        return x < MIN_DISTANCE || x > Main.GAME_SIZE - MIN_DISTANCE ||
                y < MIN_DISTANCE || y > Main.GAME_SIZE - MIN_DISTANCE;
    }

    @Override
    public String toString() {
        return "GS{" +
                "coords=" + (int)x + "," + (int)y +
                "shape=" + shape.getClass().getName().substring(19, 24) +
                '}';
    }
}
