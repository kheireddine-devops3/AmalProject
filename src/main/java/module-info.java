module com.amal.amalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;


    opens com.amal.amalproject to javafx.fxml;
    opens com.amal.amalproject.entities to javafx.fxml;
    opens com.amal.amalproject.models to javafx.fxml;
    opens com.amal.amalproject.utils to javafx.fxml;
    exports com.amal.amalproject;
    exports com.amal.amalproject.controllers;
    exports com.amal.amalproject.entities;
    opens com.amal.amalproject.controllers to javafx.fxml;
}