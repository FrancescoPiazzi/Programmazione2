module com.example.javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens stuff to javafx.fxml;
    exports stuff;
}