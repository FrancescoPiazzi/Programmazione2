package calcolatrice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Calcolatrice {
    Text result;
    public GridPane root;

    public Calcolatrice(){
        CalcolatriceModel c = new CalcolatriceModel();

        root = new GridPane();
        GridPane buttons = new GridPane();

        initButtons(buttons, c);

        result = new Text();
        root.add(result, 0, 0);
        root.add(buttons, 0, 1);
    }

    private void initButtons(GridPane gridPane, CalcolatriceModel c) {
        /*
        Genera i bottoni su gridpane e li
        collega ai metodi della calcolatrice c
        */

        // bottoni dei numeri
        int i = 0;
        for (Character n : c.numbers) {
            Button btn = new Button();
            btn.setText(Integer.toString(i));
            gridPane.add(btn, i % 3, i / 3);
            char numberToAdd = n;     // non sono sicuro del perchè funzioni
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int n = c.add(numberToAdd);
                    if(n != 0){
                        System.out.println(n);
                    }
                    result.setText(c.expression);
                }
            });
            i++;
        }

        // bottoni delle operazioni
        i = 0;
        for (Character op : c.operators) {
            Button btn = new Button();
            btn.setText(Character.toString(op));
            gridPane.add(btn, 3, i);
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    c.add(op);
                }
            });
            i++;
        }

        // bottone uguale
        Button btn = new Button();
        btn.setText("=");
        gridPane.add(btn, 1, 3);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setText(Double.toString(c.evaluate()));
            }
        });
    }
}
