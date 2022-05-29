package makearoad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// tempo impiegato: 4:00 hr
public class Main extends Application {
    GridController gridController;
    TerrainController terrainController;
    CarController carController;
    KeyBoardListener keyBoardListener;

    @Override
    public void start(Stage primaryStage) {
        gridController = new GridController();
        terrainController = new TerrainController(gridController);
        carController = new CarController(gridController);
        keyBoardListener = new KeyBoardListener(terrainController);

        generateUI(primaryStage);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyBoardListener);
    }

    public void generateUI(Stage stage){
        VBox root = new VBox();
        HBox buttons = new HBox();
        GridPane grid = gridController.generateTerrain();

        BorderPane buttonsSx = terrainController.generateButtons();
        VBox buttonsDx = carController.generateButtons();

        buttons.getChildren().addAll(buttonsSx, buttonsDx);
        root.getChildren().addAll(grid, buttons);

        buttons.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 600);
        scene.setFill(Color.GRAY);
        stage.setTitle("Make a road!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
