package makearoad;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyBoardListener implements EventHandler<KeyEvent> {
    TerrainController terrainController;
    KeyBoardListener(TerrainController terrainController){
        this.terrainController = terrainController;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        char c = Character.toLowerCase(keyEvent.getCharacter().charAt(0));
        switch (c){
            case 'n':
                terrainController.setActionAndDisable(Action.SET_NORTH, terrainController.btnN);
                break;
            case 'e':
                terrainController.setActionAndDisable(Action.SET_EAST, terrainController.btnE);
                break;
            case 's':
                terrainController.setActionAndDisable(Action.SET_SOUTH, terrainController.btnS);
                break;
            case 'w':
                terrainController.setActionAndDisable(Action.SET_WEST, terrainController.btnW);
                break;
            case 'p':
                terrainController.setActionAndDisable(Action.SET_GRASS, terrainController.btnGrass);
                break;
        }
    }
}
