package it.unitn.piazzi.esercizio;

public class LoseTile extends Tile{
    LoseTile(GridController controller) {
        super(controller);
    }

    @Override
    void scopri() {
        controller.lose();
    }

    @Override
    public String toString(){
        return "P";
    }
}
