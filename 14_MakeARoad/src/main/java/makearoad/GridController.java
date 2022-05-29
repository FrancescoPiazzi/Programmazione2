package makearoad;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import makearoad.cell.*;

import java.util.ArrayList;

public class GridController implements EventHandler<MouseEvent> {
    static final String CRASH_BANNER = "crash", ADD_CAR_ON_GRASS = "La macchina non può essere aggiunta su un prato";
    // Controller della griglia principale
    static final int GRID_SIZE = 10;

    final ArrayList<Cell> cells = new ArrayList<>();

    ButtonController controller;

    GridPane grid;
    Action action;

    int carPosition;

    GridController(){

    }

    GridPane generateTerrain(){
        grid = new GridPane();
        for(int i = 0; i<GRID_SIZE * GRID_SIZE; i++)
            cells.add(new Grass());
        updateGrid();

        grid.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        return grid;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
        if(actionEvent.getTarget() instanceof Cell){
            Cell cellClicked = (Cell)actionEvent.getTarget();
            if(isTerrainAction(action))
                handleTerrainAction(action, cellClicked);
            else if(action == Action.ADD_CAR)
                if(cellClicked instanceof Road){
                    ((Road)cellClicked).addCar();
                    carPosition = cells.indexOf(cellClicked);
                    actionFinished();
                }
                else
                    System.out.println(ADD_CAR_ON_GRASS);
        }
    }

    void moveCar(){
        Road roadStart = (Road) cells.get(carPosition);
        int destPosition = carPosition;
        boolean isDestValid = true;

        if(roadStart instanceof RoadNorth)
            destPosition -= GRID_SIZE;
        if(roadStart instanceof RoadSouth)
            destPosition += GRID_SIZE;
        if(roadStart instanceof RoadEast || roadStart instanceof RoadWest){
            int carRow = carPosition/GRID_SIZE;
            destPosition += roadStart instanceof RoadEast ? 1 : -1;
            int destRow = destPosition/GRID_SIZE;
            if(carRow != destRow)
                isDestValid = false;
        }
        if(destPosition < 0 || destPosition >= cells.size())
            isDestValid = false;

        if(isDestValid)
            if (!(cells.get(destPosition) instanceof Road))
                isDestValid = false;

        if(isDestValid){
            roadStart.removeCar();
            Road roadEnd = (Road) cells.get(destPosition);
            roadEnd.addCar();
            carPosition = destPosition;
            actionFinished();
        }
        else{
            System.out.println(CRASH_BANNER);
        }
    }

    void delCar(){
        ((Road)cells.get(carPosition)).removeCar();
        actionFinished();
    }

    void actionFinished(){
        if(controller != null)
            controller.reEnable();
        controller = null;
        action = Action.NONE;
    }

    void setController(ButtonController bc){
        if(controller != null && action != Action.ADD_CAR)
            controller.reEnable();
        controller = bc;
    }

    void handleTerrainAction(Action action, Cell target){
        Cell cellToAdd;
        int index = cells.indexOf(target);

        switch (action){
            case SET_NORTH:
                cellToAdd = new RoadNorth();
                break;
            case SET_EAST:
                cellToAdd = new RoadEast();
                break;
            case SET_SOUTH:
                cellToAdd = new RoadSouth();
                break;
            case SET_WEST:
                cellToAdd = new RoadWest();
                break;
            case SET_GRASS:
                cellToAdd = new Grass();
                break;
            default:
                cellToAdd = new Grass();
                System.out.println("Azione terreno non riconosciuta");
                break;
        }
        cells.remove(index);
        cells.add(index, cellToAdd);
        updateGrid();
        actionFinished();
    }

    void updateGrid(){
        // metodo che sincronizza l'attributo cells con la griglia visuale
        grid.getChildren().clear();
        for(int i=0; i<GRID_SIZE*GRID_SIZE; i++)
            grid.add(cells.get(i), i%GRID_SIZE, i/GRID_SIZE);
    }

    private static boolean isTerrainAction(Action a){
        return a==Action.SET_NORTH || a==Action.SET_EAST || a==Action.SET_SOUTH
                || a==Action.SET_WEST || a==Action.SET_GRASS;
    }
}
