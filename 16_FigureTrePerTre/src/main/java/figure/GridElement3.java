package figure;

import javafx.scene.control.Button;

public class GridElement3 extends GridElement{
    GridElement3(){
        Button btnCircle = new Button("O");
        Button btnTriangle = new Button("T");

        btnCircle.setOnAction(e -> setCircle());
        btnTriangle.setOnAction(e -> setTriangle());

        buttons.getChildren().addAll(btnCircle, btnTriangle);
    }
}
