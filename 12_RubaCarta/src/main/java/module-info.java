module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafxtemplate to javafx.fxml;
    exports javafxtemplate;
    exports mazzo;
    opens mazzo to javafx.fxml;
}