package it.unitn.piazzi.esercizio;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class InputDialog {
    static String getResponse(){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText("Dimensione della griglia");
        Optional<String> answer = textInputDialog.showAndWait();
        return answer.orElse(null);     // equivalente ad answer.isPresent() ? answer.get() : null
    }
}
