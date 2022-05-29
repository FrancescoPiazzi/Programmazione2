package makearoad;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CarController extends ButtonController{
    final static String ADD_CAR = "Aggiungi auto", MOVE_CAR = "Muovi auto", RESET_CAR = "Reset";

    Button btnAddCar, btnMoveCar, btnResetCar;
    Action action;

    CarController(GridController gridController){
        super(gridController);
    }

    VBox generateButtons(){
        VBox buttons = new VBox();

        btnAddCar = new Button(ADD_CAR);
        btnMoveCar = new Button(MOVE_CAR);
        btnResetCar = new Button(RESET_CAR);

        btnAddCar.setMinWidth(BUTTON_WIDTH);
        btnMoveCar.setMinWidth(BUTTON_WIDTH);
        btnResetCar.setMinWidth(BUTTON_WIDTH);

        btnMoveCar.setDisable(true);
        btnResetCar.setDisable(true);

        btnAddCar.setOnAction(e -> setActionAndDisable(Action.ADD_CAR));
        btnMoveCar.setOnAction(e -> setActionAndDisable(Action.MOVE_CAR));
        btnResetCar.setOnAction(e -> setActionAndDisable(Action.DELETE_CAR));

        buttons.getChildren().addAll(btnAddCar, btnMoveCar, btnResetCar);
        buttons.setAlignment(Pos.CENTER);

        return buttons;
    }

    void setActionAndDisable(Action a){
        action = a;
        super.setAction(a);
        if(a == Action.MOVE_CAR)
            gridController.moveCar();
        if(a == Action.DELETE_CAR)
            gridController.delCar();
    }

    @Override
    void reEnable(){
        if(action == Action.ADD_CAR || action==Action.DELETE_CAR) {
            btnAddCar.setDisable(!btnAddCar.isDisabled());
            btnMoveCar.setDisable(!btnMoveCar.isDisabled());
            btnResetCar.setDisable(!btnResetCar.isDisabled());
        }

        action = Action.NONE;
    }
}
