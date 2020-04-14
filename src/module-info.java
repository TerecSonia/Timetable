module lab1 {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.logging;
    requires java.sql;
    opens main;
    opens Repository;
    opens Domain;
}