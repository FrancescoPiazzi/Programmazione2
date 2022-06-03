package figure;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


// tempo impiegato: 2:10hr
public class Main extends Application implements EventHandler<KeyEvent> {
    static final String TRIS_BANNER = "Tre uguali in";
    static final int SIDE = 3;

    GridPane grid;

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);
        grid.addEventHandler(KeyEvent.KEY_TYPED,this);
    }

    public void generateUI(Stage stage){
        Button btnClearAll, btnCheck;

        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 500);
        grid = new GridPane();

        Random rand = new Random();
        for(int i=0; i<SIDE*SIDE; i++)
            if(rand.nextInt(2) == 0)
                grid.add(new GridElement2(), i%SIDE, i/SIDE);
            else
                grid.add(new GridElement3(), i%SIDE, i/SIDE);

        HBox bottomButtons = new HBox();
        btnClearAll = new Button("Clear all");
        btnClearAll.setOnAction(e->clearAll());
        btnCheck = new Button("Check");
        btnCheck.setOnAction(e->check());
        bottomButtons.getChildren().addAll(btnClearAll, btnCheck);

        root.getChildren().addAll(grid, bottomButtons);

        root.setAlignment(Pos.CENTER);
        grid.setAlignment(Pos.CENTER);
        bottomButtons.setAlignment(Pos.CENTER);

        stage.setTitle("Tre!");
        stage.setScene(scene);
        stage.show();
    }

    void clearAll(){
        for(Node g : grid.getChildren()){
            ((GridElement)g).clear();
        }
    }

    void check(){
        int win = checkH();
        if(win>0)
            makePopUp(TRIS_BANNER + " riga " + win);
        else{
            win = checkV();
            if(win>0)
                makePopUp(TRIS_BANNER + " colonna " + win);
        }
    }

    int checkH(){
        int n;
        for(int i=0; i<SIDE; i++){
            GridElement s = (GridElement)(grid.getChildren().get(i*SIDE));
            n = innerCheck(s, i, true);
            if(n>0)
                return n;
        }
        return 0;
    }

    int checkV(){
        int n;
        for(int i=0; i<SIDE; i++){
            GridElement s = (GridElement)(grid.getChildren().get(i));
            n = innerCheck(s, i, false);
            if(n>0)
                return n;
        }
        return 0;
    }

    int innerCheck(GridElement g, int i, boolean row){
        // confronta g con tutti gli elementi sulla riga/colonna i
        boolean win = true;
        for(int j=1; j<SIDE; j++){
            int coord = row ? i*SIDE+j : i+j*SIDE;
            GridElement s1 = (GridElement)(grid.getChildren().get(coord));
            if(!s1.equals(g)){
                win = false;
                break;
            }
        }
        return win ? i+1 : 0;
    }

    void makePopUp(String s){
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(new Text(s));
        Scene scene = new Scene(stackPane, 200, 100);

        stage.setTitle("Hai vinto!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        char c = Character.toLowerCase(keyEvent.getCharacter().charAt(0));
        if(c == 'a'){
            clearAll();
        }
        else if(c == 'c'){
            check();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
