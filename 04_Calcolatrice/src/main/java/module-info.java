module com.example.javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports main;
    exports calcolatrice;
    opens calcolatrice to javafx.fxml;
}