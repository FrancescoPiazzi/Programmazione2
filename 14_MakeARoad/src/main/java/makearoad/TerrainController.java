package makearoad;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class TerrainController extends ButtonController{
    // Controller dei bottoni che modificano il terreno
    static final String NORTH = "Strada Nord", EAST = "Strada Est", SOUTH = "Strada Sud",
            WEST = "Strada Ovest", GRASS = "Prato";

    Button btnN, btnE, btnS, btnW, btnGrass;
    Button disabledButton;

    TerrainController(GridController gridController){
        super(gridController);
    }

    BorderPane generateButtons(){
        btnN = new Button(NORTH);
        btnE = new Button(EAST);
        btnS = new Button(SOUTH);
        btnW = new Button(WEST);
        btnGrass = new Button(GRASS);

        btnN.setMinWidth(BUTTON_WIDTH);
        btnE.setMinWidth(BUTTON_WIDTH);
        btnS.setMinWidth(BUTTON_WIDTH);
        btnW.setMinWidth(BUTTON_WIDTH);
        btnGrass.setMinWidth(BUTTON_WIDTH);

        btnN.setOnAction(e -> setActionAndDisable(Action.SET_NORTH, (Button)e.getTarget()));
        btnE.setOnAction(e -> setActionAndDisable(Action.SET_EAST, (Button)e.getTarget()));
        btnS.setOnAction(e -> setActionAndDisable(Action.SET_SOUTH, (Button)e.getTarget()));
        btnW.setOnAction(e -> setActionAndDisable(Action.SET_WEST, (Button)e.getTarget()));
        btnGrass.setOnAction(e -> setActionAndDisable(Action.SET_GRASS, (Button)e.getTarget()));

        BorderPane buttons = new BorderPane();
        buttons.setTop(btnN);
        buttons.setRight(btnE);
        buttons.setBottom(btnS);
        buttons.setLeft(btnW);
        buttons.setCenter(btnGrass);

        BorderPane.setAlignment(btnN, Pos.CENTER);
        BorderPane.setAlignment(btnS, Pos.CENTER);

        return buttons;
    }

    @Override
    void reEnable(){
        disabledButton.setDisable(false);
    }

    void setActionAndDisable(Action a, Button btnPressed){
        super.setAction(a);
        enableAll();
        btnPressed.setDisable(true);

        disabledButton = btnPressed;
    }

    void enableAll(){
        btnN.setDisable(false);
        btnE.setDisable(false);
        btnS.setDisable(false);
        btnW.setDisable(false);
        btnGrass.setDisable(false);
    }
}
