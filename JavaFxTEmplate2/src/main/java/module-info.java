module javafxtemplate.javafxtemplate2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafxtemplate.javafxtemplate2 to javafx.fxml;
    exports javafxtemplate.javafxtemplate2;
}