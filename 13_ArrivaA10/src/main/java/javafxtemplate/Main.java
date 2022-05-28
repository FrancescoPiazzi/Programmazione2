package javafxtemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

// tempo impiegato: 3:50 hr
public class Main extends Application {
    static final String SELECT_START_TEXT = "1";
    static final String CHANGE_ROW_TEXT = "Cambia riga";
    static final String CHANGE_COLUMN_TEXT = "Cambia colonna";

    static final String WIN_BANNER = "Hai vinto :D";
    static final String LOSE_BANNER = "Hai perso D:";
    static final String DRAW_BANNER = "Parità -_-";

    // dimensione del lato della griglia "interna" (quadrati laterali non considerati)
    static final int GRID_SIZE = 4;

    GridPane grid;
    Button btnSelect, btnRow, btnColumn;

    Boolean win, lose;

    final ArrayList<QuadratoRiga> rowSquares = new ArrayList<>();
    final ArrayList<QuadratoColonna> columnSquares = new ArrayList<>();

    // mi serve per settare il listener della tastiera nel metodo apposta
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        win = false;
        lose = false;
        generateUI(primaryStage);
        addListeners();
        // controllo se ho vinto/perso/pareggiato appena messi giù i bottoni
        actionFinished();
    }

    void generateUI(Stage stage){
        VBox root = new VBox();

        btnSelect = new Button(SELECT_START_TEXT);
        btnRow = new Button(CHANGE_ROW_TEXT);
        btnColumn = new Button(CHANGE_COLUMN_TEXT);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(btnSelect, btnRow, btnColumn);

        generateGrid();

        root.getChildren().addAll(grid, buttons);

        scene = new Scene(root, 250, 300);
        stage.setTitle("Arriva a 10");
        stage.setScene(scene);
        stage.show();
    }

    void generateGrid(){
        ArrayList<QuadratoInGriglia> quadrati = new ArrayList<>();
        grid = new GridPane();
        for(int i=0; i<GRID_SIZE*GRID_SIZE; i++) {
            QuadratoInGriglia quadratoToAdd;
            if(new Random().nextInt(2) == 0)
                quadratoToAdd = new QuadratoBlu();
            else
                quadratoToAdd = new QuadratoGrigio();
            grid.add(quadratoToAdd, i%GRID_SIZE, i/GRID_SIZE);
            quadrati.add(quadratoToAdd);
        }

        for(int i=0; i<GRID_SIZE; i++) {
            ArrayList<QuadratoInGriglia> quadratiInCol = new ArrayList<>();
            ArrayList<QuadratoInGriglia> quadratiInRow = new ArrayList<>();

            for(int j=0; j<GRID_SIZE; j++) {
                quadratiInCol.add(quadrati.get(j * GRID_SIZE + i));
                quadratiInRow.add(quadrati.get(j + i * GRID_SIZE));
            }

            QuadratoColonna qColonna = new QuadratoColonna(quadratiInCol,this);
            grid.add(qColonna, i, GRID_SIZE);
            columnSquares.add(qColonna);
            qColonna.update(false);

            QuadratoRiga qRiga = new QuadratoRiga(quadratiInRow, this);
            grid.add(qRiga, GRID_SIZE, i);
            rowSquares.add(qRiga);
            qRiga.update(false);
        }
    }

    void addListeners(){
        btnSelect.setOnAction(e -> {
            int n = getButtonNumber();
            n = QuadratoInGriglia.adjustNumber(n);
            ((Button)e.getTarget()).setText(Integer.toString(n));
        });

        scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            char charPressed = e.getCharacter().charAt(0);
            if(charPressed >= '1' && charPressed <= Character.forDigit(GRID_SIZE, 10)){
                btnSelect.setText(Character.toString(charPressed));
            }
        });

        btnRow.setOnAction(e -> {
            int n = getButtonNumber();
            rowSquares.get(n-1).update(true);
            for(QuadratoColonna q : columnSquares)
                q.update(false);
            actionFinished();
        });

        btnColumn.setOnAction(e -> {
            int n = getButtonNumber();
            columnSquares.get(n-1).update(true);
            for(QuadratoRiga q : rowSquares)
                q.update(false);
            actionFinished();
        });
    }

    void win(){
        win = true;
        disableAll();
    }

    void lose(){
        lose = true;
        disableAll();
    }

    void actionFinished(){
        if(win && lose)
            displayPopUp(DRAW_BANNER);
        else if(win)
            displayPopUp(WIN_BANNER);
        else if(lose)
            displayPopUp(LOSE_BANNER);
    }

    void displayPopUp(String text){
        Stage stage = new Stage();
        StackPane root = new StackPane();
        root.getChildren().add(new Text(text));
        Scene s = new Scene(root, 200, 100);
        stage.setScene(s);
        stage.show();
    }

    void disableAll(){
        btnColumn.setDisable(true);
        btnRow.setDisable(true);
    }

    int getButtonNumber(){
        return Integer.parseInt(btnSelect.getText());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
