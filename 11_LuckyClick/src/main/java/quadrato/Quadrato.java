package quadrato;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import luckyclick.Main;

public class Quadrato extends Button implements EventHandler<ActionEvent> {
    final static int SIZE=60;
    final static Color DEFAULT_BACKGROUND = Color.ORANGE;
    Color backgroundColor;

    Main master;
    String text;
    Boolean disabled;

    public Quadrato(Main master){
        this.addEventHandler(ActionEvent.ACTION, this);
        this.master = master;

        disabled = false;

        this.setPrefSize(SIZE, SIZE);
        backgroundColor = DEFAULT_BACKGROUND;
        updateBackground();
    }

    @Override
    public void handle(ActionEvent e){
        if(!disabled) {
            showAndDisable();
            decreaseAttempts();
        }
    }

    void decreaseAttempts(){
        int newAttempts = Integer.parseInt(master.getAttempts().getText()) - 1;
        master.getAttempts().setText(Integer.toString(newAttempts));

        if(newAttempts == 0)
            master.gameOver();
    }

    public int getNewScore(int score){
        return score;
    }

    public void showAndDisable(){
        if(!disabled) {
            updateBackground();
            master.getScore().setText(Integer.toString(getNewScore(Integer.parseInt(master.getScore().getText()))));
            this.setText(text);
            this.removeEventHandler(ActionEvent.ACTION, this);
        }
        disable();
    }

    void updateBackground(){
        this.setBackground(new Background(new BackgroundFill(
                backgroundColor,
                new CornerRadii(5),
                new Insets(3)
        )));
    }

    public void disable(){
        disabled = true;
    }
}
