module org.studdybuddy.studdybuddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.google.gson;

    opens org.studdybuddy to javafx.fxml;
    exports org.studdybuddy;
    exports courses;
    opens courses to javafx.fxml, com.google.gson;
    exports controllers;
    opens controllers to javafx.fxml;
    opens user to com.google.gson;
}