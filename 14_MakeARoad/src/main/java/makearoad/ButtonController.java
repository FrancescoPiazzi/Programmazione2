package makearoad;

public abstract class ButtonController {
    static final int BUTTON_WIDTH = 120;

    GridController gridController;

    ButtonController(GridController gridController){
        this.gridController = gridController;
    }

    void setAction(Action a){
        gridController.setController(this);
        gridController.action = a;
    }

    void reEnable(){

    }
}
