package javafxtemplate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// ho sbagliato tutto, Atleta e Studente dovevano essere interfacce, a fare sto schifo ci ho messo 2:00 hr
public class Main extends Application {
    static final String BANNER_TUTTI = "Tutti";
    static final String BANNER_STUDENTI = "Studenti";
    static final String BANNER_ATLETI = "Atleti";
    static final String BANNER_NOME = "Nome";
    static final String BANNER_ETA = "Età";

    Button btnTutti, btnStudenti, btnAtleti, btnNome, btnEta;
    Text textBox;

    Iscritti iscritti = new Iscritti();
    Iscritti visualizedList = new Iscritti();

    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);

        iscritti.add(new Studente("Bianchi", "Anna", "BNCNN123", 4, 1990, "UNIPD", Laurea.MAGISTRALE));
        iscritti.add(new Studente("Bianchi", "Giovanni", "BNCGVN123", 3, 1995, "UNITN", Laurea.TRIENNALE));
        iscritti.add(new Studente("Ferrari", "Alberto", "BNCNN123", 7, 1993, "UNITN", Laurea.MAGISTRALE));
        iscritti.add(new Studente("Ferrari", "Vincenzo", "BNCNN123", 8, 1997, "UNIVR", Laurea.TRIENNALE));
        iscritti.add(new Atleta("Bianchi", "Panna", "BNCNN123", 1, 1993, LivelloAtleta.INTERNAZIONALE));
        iscritti.add(new Atleta("Bianchi", "Canna", "BNCNN123", 11, 1993, LivelloAtleta.NAZIONALE));

        addListeners();
        updateText(iscritti);
    }

    public void generateUI(Stage stage){
        BorderPane root = new BorderPane();
        HBox top = new HBox();
        HBox filtri = new HBox();
        HBox ordinamenti = new HBox();

        btnTutti = new Button(BANNER_TUTTI);
        btnStudenti = new Button(BANNER_STUDENTI);
        btnAtleti = new Button(BANNER_ATLETI);
        btnNome = new Button(BANNER_NOME);
        btnEta = new Button(BANNER_ETA);

        filtri.getChildren().addAll(btnTutti, btnStudenti, btnAtleti);
        ordinamenti.getChildren().addAll(btnNome, btnEta);

        top.getChildren().addAll(filtri, ordinamenti);
        top.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        root.setTop(top);

        textBox = new Text();
        root.setCenter(textBox);

        Scene scene = new Scene(root, 500, 250);
        stage.setTitle("Palestra");
        stage.setScene(scene);
        stage.show();
    }

    void addListeners(){
        btnTutti.setOnAction(e -> {
            updateFilterButtons(btnTutti);
            updateText(iscritti);
        });
        btnStudenti.setOnAction(e -> {
            Iscritti studenti = new Iscritti();
            for(Iscritto i : iscritti)
                if(i instanceof Studente)
                    studenti.add(i);
            updateFilterButtons(btnStudenti);
            updateText(studenti);
        });
        btnAtleti.setOnAction(e -> {
            Iscritti atleti = new Iscritti();
            for(Iscritto i : iscritti)
                if(i instanceof Atleta)
                    atleti.add(i);
            updateFilterButtons(btnAtleti);
            updateText(atleti);
        });
        btnNome.setOnAction(e -> {
            visualizedList.sortByName();
            updateSortButtons(btnNome, btnEta);
            updateText();
        });
        btnEta.setOnAction(e -> {
            visualizedList.sortByAge();
            updateSortButtons(btnEta, btnNome);
            updateText();
        });
    }

    void updateSortButtons(Button btnClicked, Button btnToEnable){
        btnClicked.setDisable(true);
        btnToEnable.setDisable(false);
    }

    void updateFilterButtons(Button btnClicked){
        btnTutti.setDisable(false);
        btnStudenti.setDisable(false);
        btnAtleti.setDisable(false);
        btnClicked.setDisable(true);
    }

    void updateText(){
        textBox.setText(visualizedList.toString());
    }

    void updateText(Iscritti l){
        visualizedList = l;
        updateText();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
