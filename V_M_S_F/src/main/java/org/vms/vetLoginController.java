package org.vms;


import JDBC.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class vetLoginController implements Initializable {

    @FXML
    private TextField vetEmail;

    @FXML
    private PasswordField vetPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @FXML
    void ChangeUserButtonClicked(ActionEvent event) throws IOException {
        Parent adminParent = FXMLLoader.load(getClass().getResource("SelectUser.fxml"));
        Scene ChangeUserScene = new Scene(adminParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ChangeUserScene);
        window.show();
    }

    public vetLoginController() {
        con = Connect.getConnection();
    }

    private String logIn() {
        String status = "Success";
        String email = vetEmail.getText();
        String password = vetPassword.getText();
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            //query
            String sql = "SELECT * FROM veterinary_management_system.vet Where vetEmail = ? and vetWorkPhone = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } else {
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        return status;
    }

    private void setLblError(Color color, String text) {
        lblError.setTextFill(color);
        lblError.setText(text);
        System.out.println(text);
    }

    @FXML
    void LogInButtonClicked(ActionEvent event){
        if (event.getSource() == btnLogin) {
            //login here
            if (logIn().equals("Success")) {
                try {

                    Parent adminParent = FXMLLoader.load(getClass().getResource("vet.fxml"));
                    Scene adminParentScene = new Scene(adminParent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(adminParentScene);
                    window.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (con == null) {
            lblError.setTextFill(Color.TOMATO);
            lblError.setText("Server Error : Check");
        } else {
            lblError.setTextFill(Color.GREEN);
            lblError.setText("Server is up : Good to go");
        }
    }
}
