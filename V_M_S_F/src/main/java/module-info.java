module org.vms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.vms to javafx.fxml;
    exports org.vms;
    exports org.vms.VetDBTableModel;
    exports org.vms.CustomerDBTableModel;
}