module com.amal.amalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.media;
	requires mysql.connector.java;
	  

    opens com.amal.amalproject to javafx.fxml;
    exports com.amal.amalproject;
    
    exports com.amal.amalproject.controllers;
    opens com.amal.amalproject.controllers to javafx.fxml;
    
    opens com.amal.amalproject.entities to javafx.fxml;
    exports  com.amal.amalproject.entities;
    
    
    exports  com.amal.amalproject.models;
    opens com.amal.amalproject.models;
    

    
   
     



//    opens com.amal.amalproject.models to javafx.fxml;
}