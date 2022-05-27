package javafxtemplate;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class GameController {
    Main main;
    Giocatore turno;

    GameController(Main main){
        this.main = main;
        turno = Giocatore.GIOCATORE_1;
    }

    void startGame(){
        pickPhase();
    }

    void endGame(){
        disableAll();
        String winningPlayer = turno == Giocatore.GIOCATORE_1 ? main.USERNAME_1 : main.USERNAME_2;
        String message = winningPlayer + " ha vinto!";

        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }

    void pickPhase(){
        disableAll();
        if(turno == Giocatore.GIOCATORE_1){
            main.btnPescaAvversario1.setDisable(false);
            main.btnPescaMazzo1.setDisable(false);
        }
        else{
            main.btnPescaAvversario2.setDisable(false);
            main.btnPescaMazzo2.setDisable(false);
        }
    }

    void nextTurn(){
        turno = turno==Giocatore.GIOCATORE_1 ? Giocatore.GIOCATORE_2 : Giocatore.GIOCATORE_1;
    }

    void eliminatePhase(){
        disableAll();
        if(turno == Giocatore.GIOCATORE_1)
            main.btnScartaCoppie1.setDisable(false);
        else
            main.btnScartaCoppie2.setDisable(false);
    }

    void disableAll(){
        main.btnPescaAvversario1.setDisable(true);
        main.btnPescaAvversario2.setDisable(true);
        main.btnScartaCoppie1.setDisable(true);
        main.btnScartaCoppie2.setDisable(true);
        main.btnPescaMazzo1.setDisable(true);
        main.btnPescaMazzo2.setDisable(true);
    }
}
