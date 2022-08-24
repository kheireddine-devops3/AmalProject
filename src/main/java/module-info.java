module com.amal.amalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;
	requires javafx.base;


    opens com.amal.amalproject to javafx.fxml;
    exports com.amal.amalproject;
    exports com.amal.amalproject.controllers;
    opens com.amal.amalproject.controllers to javafx.fxml;
}