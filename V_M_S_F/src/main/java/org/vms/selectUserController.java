package org.vms;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class selectUserController {


    @FXML
    void CustomerButtonClicked(ActionEvent event) throws IOException {

        Parent adminParent = FXMLLoader.load(getClass().getResource("customer.fxml"));
        Scene adminParentScene = new Scene(adminParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adminParentScene);
        window.show();

    }

    @FXML
    void VeterinarianButtonClicked(ActionEvent event) throws IOException {
        Parent adminParent = FXMLLoader.load(getClass().getResource("vetLogin.fxml"));
        Scene adminParentScene = new Scene(adminParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adminParentScene);
        window.show();

    }

}
