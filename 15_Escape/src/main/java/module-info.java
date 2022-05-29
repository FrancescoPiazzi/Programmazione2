module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens escapegame to javafx.fxml;
    exports escapegame;
}