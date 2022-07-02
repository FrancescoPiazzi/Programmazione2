module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafxtemplate to javafx.fxml;
    exports javafxtemplate;
    exports javafxtemplate.cella;
    opens javafxtemplate.cella to javafx.fxml;
}