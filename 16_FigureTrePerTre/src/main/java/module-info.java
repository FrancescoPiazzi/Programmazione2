module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens figure to javafx.fxml;
    exports figure;
}