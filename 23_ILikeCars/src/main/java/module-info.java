module it.unitn.piazzi.esercizio {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.unitn.piazzi.esercizio to javafx.fxml;
    exports it.unitn.piazzi.esercizio;
    exports it.unitn.piazzi.esercizio.car;
    opens it.unitn.piazzi.esercizio.car to javafx.fxml;
}