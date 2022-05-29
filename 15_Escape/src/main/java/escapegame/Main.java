package escapegame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


// tempo impiegato: 3:10hr (di cui 1 ora solo per togliere un /2 -_-)
public class Main extends Application implements EventHandler<KeyEvent> {
    static final int GAME_SIZE = 500;
    static final int ADD_ENEMY_INTERVAL = 10;
    static final int POINTS_PER_ITERATION = 100;

    StackPane root;
    Scene scene;
    ArrayList<Enemy> enemies;
    User user;

    int iterations;

    @Override
    public void start(Stage primaryStage) {
        enemies = new ArrayList<>();
        iterations = 0;
        generateUI(primaryStage);
    }

    public void generateUI(Stage stage){
        root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);

        user = new User();

        root.getChildren().add(user);
        addEnemy(EnemyType.STRIKER);
        addEnemy(EnemyType.WANDERER);
        addEnemy(EnemyType.BUBBLER);

        scene = new Scene(root, GAME_SIZE, GAME_SIZE);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this);

        stage.setTitle("Escape!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        boolean iterate = true;
        switch (keyEvent.getCode()){
            case UP:
                user.addY(-Palla.STEP_SIZE);
                break;
            case RIGHT:
                user.addX(Palla.STEP_SIZE);
                break;
            case DOWN:
                user.addY(Palla.STEP_SIZE);
                break;
            case LEFT:
                user.addX(-Palla.STEP_SIZE);
                break;
            default:
                iterate = false;
        }
        if(iterate)
            iterate();
    }

    void iterate(){
        boolean gameOver = false;
        iterations++;

        enemies.forEach(Enemy::update); // equivalente a enemies.forEach(enemy -> enemy.update())
        for(Enemy e : enemies) {
            if (user.isColliding(e)) {
                gameOver = true;
                user.setFill(Color.RED);
                e.setFill(Color.RED);
                break;
            }
        }
        if(gameOver) {
            scene.removeEventFilter(KeyEvent.KEY_PRESSED, this);

            Stage punteggio = new Stage();
            punteggio.setTitle("Game over!");
            Text punteggioText = new Text("Punteggio: " + iterations*POINTS_PER_ITERATION);
            StackPane sp = new StackPane();
            sp.getChildren().add(punteggioText);

            Scene s = new Scene(sp, 200, 100);
            punteggio.setScene(s);
            punteggio.show();
        }
        else if(iterations % ADD_ENEMY_INTERVAL == 0)
            addEnemy();
    }

    void addEnemy(){
        EnemyType type;
        switch (new Random().nextInt(3)){
            case 0:
                type = EnemyType.STRIKER;
                break;
            case 1:
                type = EnemyType.WANDERER;
                break;
            case 2:
                type = EnemyType.BUBBLER;
                break;
            default:
                type = null;
                break;
        }
        addEnemy(type);
    }

    void addEnemy(EnemyType type){
        Enemy enemy;
        do{
            switch (type){
                case STRIKER:
                    enemy = new Striker();
                    break;
                case WANDERER:
                    enemy = new Wanderer();
                    break;
                case BUBBLER:
                    enemy = new Bubbler();
                    break;
                default:
                    enemy = null;
                    break;
            }
        }while (user.isColliding(enemy));

        enemies.add(enemy);
        root.getChildren().add(enemy);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
