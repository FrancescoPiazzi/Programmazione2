module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens luckyclick to javafx.fxml;
    exports luckyclick;
    exports quadrato;
    opens quadrato to javafx.fxml;
}