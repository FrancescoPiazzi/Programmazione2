package javafxtemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        generateUI(primaryStage);
    }

    public void generateUI(Stage stage){
        VBox root = new VBox();

        BorderPane bp1 = new BorderPane();
        BorderPane bp2 = new BorderPane();

        Text t1 = new Text("hahaha");
        Text t2 = new Text("hehe");

        // BorderPane.setAlignment(t, Pos.CENTER_RIGHT);

        bp1.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        bp1.setCenter(t1);
        bp2.setCenter(t2);

        root.getChildren().addAll(bp1, bp2);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
