package com.example.javafxtemplate;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameSquare extends Button implements EventHandler<MouseEvent> {
    final static String flag = "|>";

    boolean bomb;
    boolean disabled;
    int bombNeighbors;
    int x, y;
    Main master;

    GameSquare(Main master, int x, int y){
        bomb = Math.random() < 1/7.3;
        this.master = master;
        this.x = x;
        this.y = y;
        disabled = false;
        this.setText(" ");
        this.setBackground(new Background(
                new BackgroundFill(Color.gray(0.65), new CornerRadii(5), new Insets(3))
        ));
        this.setFont(Font.font(Font.getDefault().getFamily(),FontWeight.BOLD, 16));
    }

    void setBombNeighbors(int n){
        if(!bomb)
            bombNeighbors = n;
        else
            bombNeighbors = -1;
    }

    void disable(){
        this.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
        this.setBackground(new Background(
                new BackgroundFill(Color.gray(0.73), new CornerRadii(5), new Insets(3))
        ));
        if(!this.getText().equals(flag)) {
            switch (bombNeighbors) {
                case 0:
                    this.setTextFill(Color.BLACK);
                    break;
                case 1:
                    this.setTextFill(Color.BLUE);
                    break;
                case 2:
                    this.setTextFill(Color.GREEN);
                    break;
                case 3:
                    this.setTextFill(Color.RED);
                    break;
                case 4:
                    this.setTextFill(Color.PURPLE);
                    break;
                default:
                    this.setTextFill(Color.DARKRED);
                    break;
            }
        }
        disabled = true;
    }

    void showCounter(){
        this.setText(!bomb ? Integer.toString(bombNeighbors) : "*");
        this.disable();
    }

    void setFlag(){
        this.setText(this.getText().equals(flag) ? " " : flag);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            if (bomb)
                master.gameOver();
            master.showBombCounters(x, y);
            master.checkWin();
        }
        if(mouseEvent.getButton() == MouseButton.SECONDARY || mouseEvent.getButton() == MouseButton.MIDDLE){
            this.setFlag();
        }
    }
}
