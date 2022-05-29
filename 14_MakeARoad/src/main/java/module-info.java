module javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens makearoad to javafx.fxml;
    exports makearoad;
    exports makearoad.cell;
    opens makearoad.cell to javafx.fxml;
}