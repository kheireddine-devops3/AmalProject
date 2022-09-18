module com.amal.amalproject {
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
    requires org.controlsfx.controls;
    requires org.apache.commons.codec;
    requires org.apache.commons.io;
    opens com.amal.amalproject to javafx.fxml;
    exports com.amal.amalproject;
    exports com.amal.amalproject.entities;
    exports com.amal.amalproject.controllers;
    opens com.amal.amalproject.controllers to javafx.fxml;
    opens com.amal.amalproject.entities to javafx.fxml;
}