package javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mazzo.Mano;
import mazzo.Mazzo;


public class Main extends Application {
    static final String PESCA_AVVERSARIO = "Pesca dall'avversario";
    static final String SCARTA_COPPIE = "Cerca le coppie";
    static final String PESCA_MAZZO = "Pesca dal mazzo";

    static final String USERNAME_1 = "PIPPO";
    static final String USERNAME_2 = "PAPERINO";

    Button btnPescaAvversario1, btnPescaAvversario2;
    Button btnScartaCoppie1, btnScartaCoppie2;
    Button btnPescaMazzo1, btnPescaMazzo2;

    HBox mano1Container, mano2Container;

    Mazzo mazzo;
    Mano mano1, mano2;

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);

        GameController controller = new GameController(this);
        initCards();
        inithandlers(controller);

        controller.startGame();
    }

    private void generateUI(Stage stage){
        VBox root = new VBox();

        btnPescaAvversario1 = new Button(PESCA_AVVERSARIO);
        btnPescaAvversario2 = new Button(PESCA_AVVERSARIO);
        btnScartaCoppie1 = new Button(SCARTA_COPPIE);
        btnScartaCoppie2 = new Button(SCARTA_COPPIE);
        btnPescaMazzo1 = new Button(PESCA_MAZZO);
        btnPescaMazzo2 = new Button(PESCA_MAZZO);

        HBox top = new HBox(new Text(USERNAME_1), btnPescaAvversario1, btnScartaCoppie1, btnPescaMazzo1);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20, 0, 20, 0));
        HBox bottom = new HBox(new Text(USERNAME_2), btnPescaAvversario2, btnScartaCoppie2, btnPescaMazzo2);
        bottom.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20, 0, 20, 0));

        mano1Container = new HBox();
        mano1Container.setAlignment(Pos.CENTER);
        mano2Container = new HBox();
        mano2Container.setAlignment(Pos.CENTER);

        root.getChildren().addAll(top, mano1Container, mano2Container, bottom);

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("\"\"\"Blackjack\"\"\"");
        stage.setScene(scene);
        stage.show();
    }

    private void initCards(){
        mazzo = new Mazzo();
        mazzo.fill();
        mazzo.shuffle();

        mano1 = new Mano(mano1Container, mazzo);
        mano2 = new Mano(mano2Container, mazzo);
    }

    private void inithandlers(GameController controller){
        btnPescaAvversario1.addEventHandler(ActionEvent.ACTION, new RubaCartaHandler(mano1, mano2, controller));
        btnPescaAvversario2.addEventHandler(ActionEvent.ACTION, new RubaCartaHandler(mano2, mano1, controller));
        btnScartaCoppie1.addEventHandler(ActionEvent.ACTION, new ScartaCoppieHandler(mano1, btnPescaMazzo1, controller));
        btnScartaCoppie2.addEventHandler(ActionEvent.ACTION, new ScartaCoppieHandler(mano2, btnPescaMazzo2, controller));
        btnPescaMazzo1.addEventHandler(ActionEvent.ACTION, new PescaMazzoHandler(mano1, mazzo, controller));
        btnPescaMazzo2.addEventHandler(ActionEvent.ACTION, new PescaMazzoHandler(mano2, mazzo, controller));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
