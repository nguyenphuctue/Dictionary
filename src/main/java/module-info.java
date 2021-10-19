open module uet.dictionary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires freetts;

//    opens uet.dictionary to javafx.fxml, javafx.base;
//    opens uet.dictionary.controllers to javafx.fxml;

    exports uet.dictionary;
    exports uet.dictionary.controllers;
}