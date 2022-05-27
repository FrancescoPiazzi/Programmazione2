module javafxtemplate {
    requires javafx.controls;
    requires javafx.base;


    opens javafxtemplate to javafx.fxml;
    exports javafxtemplate;
    exports mazzo;
    opens mazzo to javafx.fxml;
}