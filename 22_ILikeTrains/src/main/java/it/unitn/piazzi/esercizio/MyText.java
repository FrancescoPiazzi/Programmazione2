package it.unitn.piazzi.esercizio;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MyText extends Text {
    MyText(String s){
        super(s);
        setFont(new Font("Arial", 25));

    }
}
