package figure;

import javafx.scene.control.Button;

import java.util.Random;

public class GridElement2 extends GridElement{
    GridElement2(){
        Button btnRandom = new Button("R");
        btnRandom.setOnAction(e -> setRandom());
        buttons.getChildren().add(btnRandom);
    }

    void setRandom(){
        if(new Random().nextInt(2) == 0)
            setCircle();
        else
            setTriangle();
    }
}
