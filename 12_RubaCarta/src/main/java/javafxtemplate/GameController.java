package javafxtemplate;

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
        if(turno == Giocatore.GIOCATORE_1)
            System.out.print(Main.USERNAME_1);
        else
            System.out.print(Main.USERNAME_2);
        System.out.println(" ha vinto");
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
