package stuff;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int nColonne = 8, nRighe = 8;
    private int colonna, riga;
    private final GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        EventHandler<MouseEvent> clickHandler = (MouseEvent e) -> {
            if(e.getSource() instanceof Figura){
                ((Figura)e.getSource()).change();
            }
        };
        EventHandler<KeyEvent> keyBoardHandler = (KeyEvent e) -> {
            if(isValidCoord(e.getCharacter())) {
                if (riga == -1)
                    riga = Integer.parseInt(e.getCharacter()) - 1;
                else {
                    colonna = Integer.parseInt(e.getCharacter()) - 1;
                    ((Figura)root.getChildren().get(riga + colonna * nColonne)).change();
                    resetRC();
                }
            }
            else if(e.getCharacter().charAt(0) == 'c'){
                resetRC();
            }
            else if(e.getCharacter().charAt(0) == 'r'){
                resetAll();
            }
        };

        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, keyBoardHandler);
        resetRC();

        for (int i=0; i<nColonne; i++) {
            for (int j=0; j<nRighe; j++) {
                root.add(new Figura(clickHandler, i, j), i, j);
            }
        }

        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.YELLOW);
        primaryStage.setTitle("GIOCO");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void resetAll(){
        for(int i=0; i<root.getChildren().size(); i++){
            ((Figura)root.getChildren().get(i)).reset();
        }
    }

    private void resetRC(){
        riga = -1;
        colonna = -1;
    }

    private static boolean isValidCoord(String n){
        return n.length() == 1 && n.charAt(0) >= '1' && n.charAt(0) <= Integer.toString(nColonne).charAt(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}