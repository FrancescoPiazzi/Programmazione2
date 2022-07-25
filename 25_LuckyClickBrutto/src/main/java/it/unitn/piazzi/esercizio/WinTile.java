package it.unitn.piazzi.esercizio;

public class WinTile extends Tile{
    WinTile(GridController controller) {
        super(controller);
    }

    @Override
    void scopri() {
        controller.win();
    }

    @Override
    public String toString(){
        return "V";
    }
}
