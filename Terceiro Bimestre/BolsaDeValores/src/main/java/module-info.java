module com.example.bolsadevalores {
    requires javafx.controls;
    requires javafx.fxml;
    requires tornadofx.controls;


    opens com.example.bolsadevalores to javafx.fxml;
    exports com.example.bolsadevalores;
}