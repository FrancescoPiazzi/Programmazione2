package luckyclick;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import quadrato.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Main extends Application {
    final static int N_SQUARES = 10;
    final static int N_PERDUE = 10, N_DIVISODUE = 10, N_BOMBE = 5;

    final static int STARTING_ATTEMPTS = 10;
    final static String GAMOVER_BANNER = "Game over!";

    VBox root;

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);
    }

    public void generateUI(Stage stage){
        root = new VBox();

        HBox punteggio = new HBox();
        punteggio.getChildren().addAll(new Text("Punteggio: "), new Text("0"));
        punteggio.setAlignment(Pos.CENTER);
        HBox tentativi = new HBox();
        tentativi.getChildren().addAll(new Text("Tentativi: "), new Text(Integer.toString(STARTING_ATTEMPTS)));
        tentativi.setAlignment(Pos.CENTER);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        root.getChildren().addAll(punteggio, tentativi, grid);

        generateSquares();

        Scene scene = new Scene(root, 600, 650);
        stage.setTitle("Lucky click");
        stage.setScene(scene);
        stage.show();
    }

    public void bombClicked(int pos){
        int x = pos%N_SQUARES;
        int y = pos/N_SQUARES;

        for(int i=0; i<N_SQUARES; i++){
            ((Quadrato)getGrid().getChildren().get(i+y*N_SQUARES)).showAndDisable();
        }

        for(int i=0; i<N_SQUARES; i++){
            ((Quadrato)getGrid().getChildren().get(x+i*N_SQUARES)).showAndDisable();
        }
    }

    public void gameOver(){
        Iterator<Node> iterator = getGrid().getChildren().iterator();
        for (Node n = iterator.next(); iterator.hasNext(); n = iterator.next()) {
            ((Quadrato)n).disable();
        }
        getAttempts().setText(GAMOVER_BANNER);
    }

    private void generateSquares(){
        LinkedList<TipoQuadrato> pattern = generateSquarePattern();
        for(int i=0; i<N_SQUARES*N_SQUARES; i++){
            Quadrato q;
            switch (pattern.get(i)){
                case QUADRATO_DEFAULT:
                    q = new QuadratoDefault(this);
                    break;
                case QUADRATO_PERDUE:
                    q = new QuadratoPerDue(this);
                    break;
                case QUADRATO_DIVISODUE:
                    q = new QuadratoDivisoDue(this);
                    break;
                case QUADRATO_BOMBA:
                    q = new QuadratoBomba(this, i);
                    break;
                default:
                    q = new Quadrato(this);
            }
            getGrid().add(q, i%N_SQUARES, i/N_SQUARES);
        }
    }

    private LinkedList<TipoQuadrato> generateSquarePattern(){
        // genera una linked list con i tipi di quadrati random
        LinkedList<TipoQuadrato> a = new LinkedList<>();

        for(int i=0; i<N_SQUARES*N_SQUARES-N_PERDUE-N_DIVISODUE-N_BOMBE; i++)
            a.add(TipoQuadrato.QUADRATO_DEFAULT);
        for(int i=0; i<N_PERDUE; i++)
            a.add(TipoQuadrato.QUADRATO_PERDUE);
        for(int i=0; i<N_DIVISODUE; i++)
            a.add(TipoQuadrato.QUADRATO_DIVISODUE);
        for(int i=0; i<N_BOMBE; i++)
            a.add(TipoQuadrato.QUADRATO_BOMBA);

        Collections.shuffle(a);

        return a;
    }

    public Text getScore(){
        return (Text)((HBox)root.getChildren().get(0)).getChildren().get(1);
    }

    public Text getAttempts(){
        return (Text)((HBox)root.getChildren().get(1)).getChildren().get(1);
    }

    public GridPane getGrid(){
        return (GridPane) root.getChildren().get(2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
