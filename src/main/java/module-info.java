module proiect {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens assignment1_polinoame to javafx.fxml;
    exports assignment1_polinoame;
}