module uet.dictionary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires freetts;

    opens uet.dictionary to javafx.fxml;
    exports uet.dictionary;
    exports uet.dictionary.controller;
    opens uet.dictionary.controller to javafx.fxml;
}