package com.example.javafxtemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    final int SQUARES_SIDE = 10;
    final int SQUARES_SIZE = 50;

    private ArrayList<GameSquare> squares;
    private GridPane field;
    private HBox stateContainer;
    private boolean gameLost;

    @Override
    public void start(Stage primaryStage) {
        squares = new ArrayList<>();
        field = new GridPane();
        gameLost = false;
        GridPane root = new GridPane();
        stateContainer = new HBox();
        stateContainer.setPadding(new Insets(20));

        Text gameState = new Text("");
        gameState.setFont(new Font(21));
        gameState.setTextAlignment(TextAlignment.CENTER);

        stateContainer.getChildren().add(gameState);
        stateContainer.setAlignment(Pos.CENTER);
        root.add(field, 0, 1);
        root.add(stateContainer, 0, 0);
        root.setAlignment(Pos.CENTER);

        setResetBoard();

        Scene scene = new Scene(root, 550, 600);
        primaryStage.setTitle("Prato fiorito");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void disableAll(){
        for(GameSquare s : squares)
            s.disable();
    }

    void ShowAllBombs(){
        for(GameSquare s : squares)
            if(s.bomb)
                s.showCounter();
    }

    void setBombCounters(){
        for(int i=0; i<SQUARES_SIDE; i++){
            for(int j=0; j<SQUARES_SIDE; j++){
                int bombs = 0;
                for(int x=i-1; x<=i+1; x++){
                    for(int y=j-1; y<=j+1; y++){
                        if(!(x == i && y == j) && isValid(x, y) && squares.get(x*SQUARES_SIDE+y).bomb){
                            bombs++;
                        }
                    }
                }
                squares.get(i*SQUARES_SIDE+j).setBombNeighbors(bombs);
            }
        }
    }

    void showBombCounters(int i, int j){
        GameSquare clickedElement = squares.get(i*SQUARES_SIDE+j);

        clickedElement.showCounter();

        if(clickedElement.bombNeighbors == 0) {
            for (int x = i - 1; x <= i + 1; x++) {
                for (int y = j - 1; y <= j + 1; y++) {
                    if (!(x == i && y == j) && isValid(x, y)) {
                        GameSquare s = squares.get(x * SQUARES_SIDE + y);
                        if (!s.disabled) {
                            s.showCounter();
                            if (s.bombNeighbors == 0)
                                showBombCounters(x, y);
                        }
                    }
                }
            }
        }
    }

    void checkWin(){
        boolean win = !gameLost;
        for(int i=0; i<SQUARES_SIDE*SQUARES_SIDE; i++){
            if (!squares.get(i).bomb && !squares.get(i).disabled) {
                win = false;
                break;
            }
        }
        if(win){
            getGameState().setText("Hai vinto :D");
            disableAll();
            endGame();
        }
    }

    void gameOver(){
        gameLost = true;
        disableAll();
        ShowAllBombs();
        getGameState().setText("Hai perso");
        endGame();
    }

    void endGame(){
        HBox buttonWrapper = new HBox();
        buttonWrapper.setPadding(new Insets(0, 0, 0, 20));

        Button btnRiprova = new Button("Riprova");
        buttonWrapper.getChildren().add(btnRiprova);

        stateContainer.getChildren().add(buttonWrapper);
        btnRiprova.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stateContainer.getChildren().remove(buttonWrapper);
                setResetBoard();
            }
        });
    }

    private void setResetBoard(){
        field.getChildren().removeAll(squares);
        squares.removeAll(squares);
        for(int i=0; i<SQUARES_SIDE*SQUARES_SIDE; i++){
            GameSquare s = new GameSquare(this,i/SQUARES_SIDE, i%SQUARES_SIDE);
            field.add(s, i/SQUARES_SIDE, i%SQUARES_SIDE);
            s.setMinSize(SQUARES_SIZE, SQUARES_SIZE);
            squares.add(s);
            s.addEventHandler(MouseEvent.MOUSE_CLICKED, s);
        }
        setBombCounters();
        getGameState().setText("");
    }

    private Text getGameState(){
        return (Text)(stateContainer.getChildren().get(0));
    }

    private boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x <= SQUARES_SIDE - 1 && y <= SQUARES_SIDE - 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}