package javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// tempo impiegato 3:15 (più un ora di depressione perchè non mi ricordavo come si spostano gli elementi)
public class Main extends Application {
    static final int GAME_SIZE = 500;

    MovementHandler handler;
    Controller controller;

    @Override
    public void start(Stage primaryStage) {
        // Inizializzo gli elementi principali dell'interfaccia
        VBox root = new VBox();
        HBox bot = new HBox();
        StackPane mainStackPane = new StackPane();
        TextField increaseField = new TextField("10");
        Text punteggio = new Text("500");

        // Inizializzo i bottoni
        Button btnSu = new Button("Su");
        Button btnDestra = new Button("Destra");
        Button btnGiu = new Button("Giu");
        Button btnSinistra = new Button("Sinistra");
        btnSu.setId(Direction.SU.name());
        btnDestra.setId(Direction.DESTRA.name());
        btnGiu.setId(Direction.GIU.name());
        btnSinistra.setId(Direction.SINISTRA.name());

        // Metto tutti gli elementi assieme e aggiungo lo stile
        bot.getChildren().addAll(increaseField, btnSu, btnDestra, btnGiu, btnSinistra, punteggio);
        root.getChildren().addAll(mainStackPane, bot);
        mainStackPane.setAlignment(Pos.TOP_LEFT);
        mainStackPane.setMinSize(GAME_SIZE, GAME_SIZE);

        // Inizializzo il controller del gioco e il gestore degli eventi
        controller = new Controller(mainStackPane, increaseField, punteggio);
        handler = new MovementHandler(controller);

        // Aggiungo i listener dei bottoni e della tastiera
        btnSu.addEventHandler(ActionEvent.ACTION, handler);
        btnDestra.addEventHandler(ActionEvent.ACTION, handler);
        btnGiu.addEventHandler(ActionEvent.ACTION, handler);
        btnSinistra.addEventHandler(ActionEvent.ACTION, handler);
        root.addEventFilter(KeyEvent.KEY_TYPED, handler);

        // Mostro la schermata
        primaryStage.setTitle("Elimina le figure!");
        Scene scene = new Scene(root, GAME_SIZE, GAME_SIZE+50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
