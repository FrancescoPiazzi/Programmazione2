package javafxtemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafxtemplate.cella.*;

import java.util.Random;

// 16:00 -> 17:00 mi sono rotto
public class Main extends Application {
    final static int SIDE = 4;

    GridPane gp;

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);
    }

    public void generateUI(Stage stage){
        VBox root = new VBox();
        HBox buttons = new HBox();

        gp = new GridPane();
        Button btnTest = new Button("Test");
        Button btnReset = new Button("Reset");
        buttons.getChildren().addAll(btnTest, btnReset);
        root.getChildren().addAll(gp, buttons);

        btnReset.setOnAction(e -> reset());
        btnTest.setOnAction(e -> fillRandom());

        reset();

        Scene scene = new Scene(root, 700, 900);
        stage.setTitle("I like trains");
        stage.setScene(scene);
        stage.show();
    }

    public void reset(){
        gp.getChildren().clear();
        for(int i=0; i<SIDE*SIDE; i++)
            gp.add(new Vuoto(), i%SIDE, i/SIDE);
    }

    public void fillRandom(){
        gp.getChildren().clear();
        Random r = new Random();
        for(int i=0; i<SIDE*SIDE; i++){
            Cella toAdd = null;

            switch (r.nextInt(2)){
                case 0:
                    toAdd = new Dritto();
                    break;
                case 1:
                    toAdd = new CurvaC();
                    break;
            }
            gp.add(toAdd, i%SIDE, i/SIDE);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
