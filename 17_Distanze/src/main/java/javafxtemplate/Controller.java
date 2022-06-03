package javafxtemplate;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Locale;
import java.util.Random;

public class Controller {
    static final int N_SHAPES = 6;      // deve essere pari, altrimenti è come se valesse n-1

    static final int MOVE_SCORE = -5;
    static final int ELIMINATE_SHAPE_SCORE = 100;
    static final int ELIMINATE_WALL_SCORE = -50;

    StackPane mainStackPane;
    TextField increaseField;
    Text punteggio;

    Controller(StackPane stackPane, TextField textField, Text text){
        mainStackPane = stackPane;
        increaseField = textField;
        punteggio = text;

        // Aggiungo le figure
        for(int i=0; i<N_SHAPES/2; i++)
            addShape(new BlueShape());
        for(int i=0; i<N_SHAPES/2; i++) {
            RedShape shapeToAdd = new RedShape();
            addShape(shapeToAdd);
            String randomChar = Character.toString((char)(new Random().nextInt('Z' - 'A') + 'A'));
            shapeToAdd.setLabel(randomChar);
        }
    }

    void addShape(GameShape shape){
        boolean collision;
        Random rand = new Random();

        do{
            collision = false;
            shape.setCoords(rand.nextFloat()*Main.GAME_SIZE, rand.nextFloat()*Main.GAME_SIZE);
            for(Node n : mainStackPane.getChildren()){
                if(shape.isColliding() || shape.isColliding((GameShape) n)) {
                    collision = true;
                    break;
                }
            }
        }while(collision);
        shape.updatePosition();
        mainStackPane.getChildren().add(shape);
    }

    void moveAllBlue(String direction){
        ObservableList<Node> shapes = mainStackPane.getChildren();
        int incX = 0, incY = 0;
        int inc = Integer.parseInt(increaseField.getText());

        if(direction.equals(Direction.SU.toString()))
            incY = -1;
        if(direction.equals(Direction.DESTRA.toString()))
            incX = 1;
        if(direction.equals(Direction.GIU.toString()))
            incY = 1;
        if(direction.equals(Direction.SINISTRA.toString()))
            incX = -1;

        for(Node n : shapes)
            if(n instanceof BlueShape)
                ((BlueShape) n).move(inc*incX, inc*incY);

        checkCollisions();
        updateScore(MOVE_SCORE);
    }

    void moveRed(String label){
        ObservableList<Node> shapes = mainStackPane.getChildren();
        label = label.toLowerCase(Locale.ROOT);
        int inc = Integer.parseInt(increaseField.getText());

        // cerco tra tutti i quadrati a caso quale ha la label che voglio: fa schifo ma è più facile
        // che aggiungere i listener singoli a ogni quadrato
        for(Node n : shapes){
            if(n instanceof RedShape && ((RedShape) n).l.getText().toLowerCase(Locale.ROOT).equals(label)){
                ((RedShape) n).move(inc, 0);
            }
        }

        checkCollisions();
        updateScore(MOVE_SCORE);
    }

    void changeIncrement(String increment){
        char c = increment.charAt(0);
        if(c >= '0' && c<='9')
            increaseField.setText(increaseField.getText()+c);
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Non numero inserito", ButtonType.OK);
            alert.showAndWait();
        }
    }

    void updateScore(int modifier){
        punteggio.setText(Integer.toString(Integer.parseInt(punteggio.getText())+modifier));
    }

    void checkCollisions(){
        ObservableList<Node> shapes = mainStackPane.getChildren();

        for(int i=0; i<shapes.size(); i++){
            GameShape si = (GameShape)shapes.get(i);
            for(int j=i+1; j<shapes.size(); j++){
                GameShape sj = (GameShape)shapes.get(j);
                if(si.isColliding(sj)){
                    mainStackPane.getChildren().removeAll(si, sj);
                    updateScore(ELIMINATE_SHAPE_SCORE);
                }
            }
            if(si.isColliding()) {
                mainStackPane.getChildren().remove(si);
                updateScore(ELIMINATE_WALL_SCORE);
            }
        }
    }
}
