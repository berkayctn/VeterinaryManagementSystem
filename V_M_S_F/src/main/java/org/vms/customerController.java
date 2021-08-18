package org.vms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import JDBC.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.vms.CustomerDBTableModel.InvoiceCustomer;
import org.vms.CustomerDBTableModel.Reservation;

public class customerController implements Initializable {


    @FXML
    void ChangeUserButtonClicked(ActionEvent event) throws IOException {

        Parent adminParent = FXMLLoader.load(getClass().getResource("SelectUser.fxml"));
        Scene ChangeUserScene = new Scene(adminParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ChangeUserScene);
        window.show();

    }


    @FXML
    private TextField custIDForReser;

    @FXML
    private Button inquireForReser;

    @FXML
    private TableView<Reservation> reservationTableView;
    @FXML
    private TableColumn<Reservation, String> reservationYourId;

    @FXML
    private TableColumn<Reservation, String> YourReservationTableColumn;


    @FXML
    void inquireForReserClicked(ActionEvent event) {
        showReservation();

    }


    public ObservableList<Reservation> getCustomersList() {
        ObservableList<Reservation> reservationList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT custID , rDate FROM veterinary_management_system.service WHERE service.custID ='" + custIDForReser.getText() + "'";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while (rs.next()) {

                reservationList.add(new Reservation(rs.getString("custID"), rs.getString("rDate")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationList;
    }


    private void showReservation() {
        ObservableList<Reservation> list = getCustomersList();
        reservationYourId.setCellValueFactory(new PropertyValueFactory<>("reservationCustomerId"));
        YourReservationTableColumn.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));
        reservationTableView.setItems(list);
    }


    @FXML
    private TextField enterCusIdForInvoice;

    @FXML
    private Button myInvoiceButton;

    @FXML
    private TableView<InvoiceCustomer> myInvoiceTableView;

    @FXML
    private TableColumn<InvoiceCustomer, String> myInvoiceYourIdColumn;

    @FXML
    private TableColumn<InvoiceCustomer, String> myInvoicePaymentMethodColumn;

    @FXML
    private TableColumn<InvoiceCustomer, String> myInvoicePaymentDateColumn;

    @FXML
    private TableColumn<InvoiceCustomer, String> myInvoiceCostColumn;


    @FXML
    void myInvoiceButtonClicked(ActionEvent event) {
        showMyInvoices();

    }


    public ObservableList<InvoiceCustomer> getMyInvoiceList() {
        ObservableList<InvoiceCustomer> myInvoiceList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT custID , paymentMethod , paymentDate , cost FROM veterinary_management_system.invoice WHERE invoice.custID ='" + enterCusIdForInvoice.getText() + "'";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while (rs.next()) {

                myInvoiceList.add(new InvoiceCustomer(rs.getString("custID"), rs.getString("paymentMethod"), rs.getString("paymentDate"), rs.getString("cost")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myInvoiceList;
    }


    private void showMyInvoices() {
        ObservableList<InvoiceCustomer> list = getMyInvoiceList();
        myInvoiceYourIdColumn.setCellValueFactory(new PropertyValueFactory<>("myInvoiceYourId"));
        myInvoicePaymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethodCustomer"));
        myInvoicePaymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDateCustomer"));
        myInvoiceCostColumn.setCellValueFactory(new PropertyValueFactory<>("paymentCostCustomer"));
        myInvoiceTableView.setItems(list);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
