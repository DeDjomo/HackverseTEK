module cm.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires transitive java.sql;
    requires transitive javafx.graphics;
    requires jakarta.mail;

    opens cm.polytechnique to javafx.fxml, java.sql, javafx.graphics;
    exports cm.polytechnique;
    exports cm.polytechnique.Controller;
    opens cm.polytechnique.Controller to javafx.fxml;
    exports cm.polytechnique.Task;
    opens cm.polytechnique.Task to javafx.fxml;
}