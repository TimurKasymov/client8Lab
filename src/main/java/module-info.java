module client.client8lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.commons.lang3;
    requires java.management;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.google.common;
    requires org.slf4j;
    requires com.google.gson;
    requires commonpro;

    opens client.client8lab to javafx.fxml;
    exports client.client8lab;
    exports client.client8lab.GUI.Controllers;
    opens client.client8lab.GUI.Controllers to javafx.fxml;
    exports client.client8lab.validators;
    opens client.client8lab.validators to javafx.fxml;
    exports client.client8lab.backService.settings;
}