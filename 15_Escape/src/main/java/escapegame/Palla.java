package escapegame;

import javafx.scene.shape.Circle;

import java.util.Random;

public abstract class Palla extends Circle {
    static final int BASE_RADIUS = 20;
    static final int STEP_SIZE = 10;

    private double x, y;

    Palla() {
        super(BASE_RADIUS);

        this.x = generateValidCoord();
        this.y = generateValidCoord();

        updatePosition();
    }

    void addX(double x){
        this.x += x;
        updatePosition();
    }

    void addY(double y){
        this.y += y;
        updatePosition();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void updatePosition(){
        x = normalize(x);
        y = normalize(y);
        setTranslateX(x);
        setTranslateY(y);
    }

    static double normalize(double n){
        if(n < 0)
            n = Main.GAME_SIZE;
        if(n > Main.GAME_SIZE)
            n = 0;
        return n;
    }

    boolean isColliding(Palla p){
        // ritorna true se p è in collisione con l'utente
        double x1 = getCenter(getX()), x2 = p.getCenter(p.getX());
        double y1 = getCenter(getY()), y2 = p.getCenter(p.getY());

        double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        // System.out.println((int)distance + " " + (p.getRadius() + getRadius()));
        return distance <= p.getRadius() + getRadius();
    }

    double getCenter(double n){
        return n+getRadius();
    }

    static int generateValidCoord(){
        return new Random().nextInt(Main.GAME_SIZE-BASE_RADIUS*2);
    }
}
