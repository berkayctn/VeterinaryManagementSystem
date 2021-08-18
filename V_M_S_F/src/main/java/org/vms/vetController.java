package org.vms;


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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.vms.VetDBTableModel.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class vetController implements Initializable {


    /**Customer**/

    @FXML
    private TextField custID;

    @FXML
    private TextField cusFName;

    @FXML
    private TextField cusLName;

    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private TableColumn<Customer, String> custIDTableColumn;

    @FXML
    private TableColumn<Customer, String> fNameTableColumn;

    @FXML
    private TableColumn<Customer, String> lNameTableColumn;


    @FXML
    public void cusDeleteClicked(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.customer" +
                " WHERE custID='"+custID.getText()+"'";
        executor(query);
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();
    }

    @FXML
    public void cusInsertClicked(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.customer (custID,fName,lName)" +
                " VALUES('"+custID.getText()+"','"+cusFName.getText()+"','"+cusLName.getText()+"')";
        executor(query);
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();
    }

    @FXML
    public void cusUpdateClicked(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.customer SET fName='"+cusFName.getText()+"',lName='"+cusLName.getText()+"'"+" WHERE custID='"+custID.getText()+"';";
        executor(query);
       showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();
    }




    public ObservableList<Customer> getCustomersList(){
        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.customer";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                customerList.add(new Customer (rs.getString(1),
                        rs.getString(2),rs.getString(3)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList ;
    }


    public void showCustomers() {
        ObservableList<Customer> list = getCustomersList();

        custIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("custId"));
        fNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customerTableView.setItems(list);
    }




    /**Customer Phone Number Table**/

    @FXML
    private TextField customerPhoneCustId;

    @FXML
    private TextField customerPhonePhoneNum;

    @FXML
    private TableView<CustomerPhone> customerPhoneTableView;

    @FXML
    private TableColumn<CustomerPhone, String> customerPhoneCustIdColumn;

    @FXML
    private TableColumn<CustomerPhone, String> customerPhoneNumberColumn;

    @FXML
    void deleteInToCustomerPhone(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.customerphonenumber" +
                " WHERE cusPhoneNumber='"+customerPhonePhoneNum.getText()+"'";
        executor(query);
        showCustomerPhoneNumber();
        showCustomers();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    @FXML
    void insertInToCustomerPhone(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.customerphonenumber (custID,cusPhoneNumber)" +
                " VALUES('"+customerPhoneCustId.getText()+"','"+customerPhonePhoneNum.getText()+"')";
        executor(query);
        showCustomerPhoneNumber();
        showCustomers();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();
    }

    @FXML
    void updateInToCustomerPhone(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.customerphonenumber SET cusPhoneNumber='"+customerPhonePhoneNum.getText()+"'"+" WHERE cusPhoneNumber='"+customerPhoneCustId.getText()+"';";
        executor(query);
        showCustomerPhoneNumber();
        showCustomers();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    public ObservableList<CustomerPhone> getCustomerPhonesList(){
        ObservableList<CustomerPhone> customerPhoneList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.customerphonenumber";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                customerPhoneList.add(new CustomerPhone (rs.getString(1),
                        rs.getString(2)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerPhoneList ;
    }



    private void showCustomerPhoneNumber() {
        ObservableList<CustomerPhone> list = getCustomerPhonesList();

        customerPhoneCustIdColumn.setCellValueFactory(new PropertyValueFactory<>("custId"));
        customerPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("customerPhoneNumber"));
        customerPhoneTableView.setItems(list);
    }
    /**Invoice**/
    @FXML
    private TextField invoiceId;

    @FXML
    private TextField invoiceServiceId;

    @FXML
    private TextField invoiceCustomerId;

    @FXML
    private TextField invoicePaymentMethod;

    @FXML
    private TextField invoicePaymentDate;

    @FXML
    private TextField invoiceCost;

    @FXML
    private TableView<Invoice> invoiceTableView;

    @FXML
    private TableColumn<Invoice, String> invoiceIdColumn;

    @FXML
    private TableColumn<Invoice, String> invoiceServiceIdColumn;

    @FXML
    private TableColumn<Invoice, String> invoiceCustIdColumn;

    @FXML
    private TableColumn<Invoice, String> invoicePaymentMethodColumn;

    @FXML
    private TableColumn<Invoice, String> incoicePaymentDateColumn;

    @FXML
    private TableColumn<Invoice, String> invoiceCostColumn;

    @FXML
    void isertInToInvoice(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.invoice (invoiceID,serviceID,custID,paymentMethod,paymentDate,cost)" +
                " VALUES('"+invoiceId.getText()+"','"+invoiceServiceId.getText()+"','"+invoiceCustomerId.getText()+"','"+invoicePaymentMethod.getText()+"','"+invoicePaymentDate.getText()+"','"+invoiceCost.getText()+"')";
        executor(query);
        showInvoice();
        showCustomers();
        showCustomerPhoneNumber();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    @FXML
    void updateFromInvoice(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.invoice SET serviceID='"+invoiceServiceId.getText()+"',custID='"+invoiceCustomerId.getText()+"'"+",paymentMethod='"+invoicePaymentMethod.getText()+"'"+",paymentDate='"+invoicePaymentDate.getText()+"'"+",cost='"+invoiceCost.getText()+"'"+" WHERE invoiceID='"+invoiceId.getText()+"';";
        executor(query);
        showInvoice();
        showCustomers();
        showCustomerPhoneNumber();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }
    @FXML
    void deleteFromInvoice(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.invoice" +
                " WHERE invoiceID='"+invoiceId.getText()+"'";
        executor(query);
        showInvoice();
        showCustomers();
        showCustomerPhoneNumber();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    public ObservableList<Invoice> getInvoice(){
        ObservableList<Invoice> invoiceList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.invoice";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                invoiceList.add(new Invoice(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),
                        rs.getString(6)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invoiceList ;
    }



    private void showInvoice() {
        ObservableList<Invoice> invoices = getInvoice();

        invoiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        invoiceServiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        invoiceCustIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        invoicePaymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        incoicePaymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        invoiceCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        invoiceTableView.setItems(invoices);
    }

    /**Needs**/

    @FXML
    private TextField needsTableCustomerPetIdTextFiled;

    @FXML
    private TextField needsTablePetServiceIdTextFiled;

    @FXML
    private TableView<Needs> needsTableView;

    @FXML
    private TableColumn<Needs, String> needsPetIdColumn;

    @FXML
    private TableColumn<Needs, String> needsServiceIdColumn;

    @FXML
    void deleteInToNeeds(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.needs" +
                " WHERE serviceID='"+needsTablePetServiceIdTextFiled.getText()+"'";
        executor(query);
        showNeeds();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    @FXML
    void insertInToNeeds(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.needs (petID,serviceID)" +
                " VALUES('"+needsTableCustomerPetIdTextFiled.getText()+"','"+needsTablePetServiceIdTextFiled.getText()+"')";
        executor(query);
        showNeeds();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    @FXML
    void updateInToNeeds(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.needs SET serviceID='"+needsTableCustomerPetIdTextFiled.getText()+"'"+" WHERE serviceID='"+needsTablePetServiceIdTextFiled.getText()+"';";
        executor(query);
        showNeeds();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    public ObservableList<Needs> getNeedsList(){
        ObservableList<Needs> needsList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.needs";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                needsList.add(new Needs(rs.getString(1),
                        rs.getString(2)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return needsList ;
    }



    private void showNeeds() {
        ObservableList<Needs> list = getNeedsList();

        needsPetIdColumn.setCellValueFactory(new PropertyValueFactory<>("needsTableCustomerPetId"));
        needsServiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("needsTablePetServiceId"));
        needsTableView.setItems(list);
    }


    /**Pet**/
    @FXML
    private TextField petTablePetIdTextFiled;

    @FXML
    private TextField petTableCustIdTextFiled;

    @FXML
    private TextField petTablePetCharIdTextFiled;

    @FXML
    private TextField petTablePetBirthDateTextFiled;

    @FXML
    private TextField petTablePetGenderTextFiled;

    @FXML
    private TextField petTablePetTypeTextFiled;

    @FXML
    private TextField petTableAdoptionDateTextFiled;

    @FXML
    private TableView<Pet> petTableView;

    @FXML
    private TableColumn<Pet, String> petTableIdColumn;

    @FXML
    private TableColumn<Pet, String> petTableCustIdColumn;

    @FXML
    private TableColumn<Pet, String> petTableCharIdColumn;

    @FXML
    private TableColumn<Pet, String> petTableBirthDateColumn;

    @FXML
    private TableColumn<Pet, String> petTableGenderColumn;

    @FXML
    private TableColumn<Pet, String> petTableTypeColumn;

    @FXML
    private TableColumn<Pet, String> petTableadoptionDateColumn;

    @FXML
    void insertInToPet(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.pet (petID,custID,PetCharID,petBirthDate,petGender,petType,adoptionDate)" +
                " VALUES('"+petTablePetIdTextFiled.getText()+"','"+petTableCustIdTextFiled.getText()+"','"+petTablePetCharIdTextFiled.getText()+"','"+petTablePetBirthDateTextFiled.getText()+"','"+petTablePetGenderTextFiled.getText()+"','"+petTablePetTypeTextFiled.getText()+"','"+petTableAdoptionDateTextFiled.getText()+"')";
        executor(query);
        showPet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    @FXML
    void updateFromPet(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.pet SET custID='"+petTableCustIdTextFiled.getText()+"',PetCharID='"+petTablePetCharIdTextFiled.getText()+"',petBirthDate='"+petTablePetBirthDateTextFiled.getText()+"',petGender='"+petTablePetGenderTextFiled.getText()+"',petType='"+petTablePetTypeTextFiled.getText()+"',adoptionDate='"+petTableAdoptionDateTextFiled.getText()+"'"+" WHERE petID='"+petTablePetIdTextFiled.getText()+"';";
        executor(query);
        showPet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }
    @FXML
    void deleteFromPet(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.pet" +
                " WHERE petID='"+petTablePetIdTextFiled.getText()+"'";
        executor(query);
        showPet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }

    public ObservableList<Pet> getPetList(){
        ObservableList<Pet> petList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.pet";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                petList.add(new Pet(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petList ;
    }



    private void showPet() {
        ObservableList<Pet> list = getPetList();

        petTableIdColumn.setCellValueFactory(new PropertyValueFactory<>("petTablePetId"));
        petTableCustIdColumn.setCellValueFactory(new PropertyValueFactory<>("petTableCustId"));
        petTableCharIdColumn.setCellValueFactory(new PropertyValueFactory<>("petTablePetCharId"));
        petTableBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("petTablePetBirthDate"));
        petTableGenderColumn.setCellValueFactory(new PropertyValueFactory<>("petTablePetGender"));
        petTableTypeColumn.setCellValueFactory(new PropertyValueFactory<>("petTablePetType"));
        petTableadoptionDateColumn.setCellValueFactory(new PropertyValueFactory<>("petTableAdoptionDate"));
        petTableView.setItems(list);
    }



    /**Pet Characteristics **/
    @FXML
    private TextField petCharTablePetCharIdTextFiled;

    @FXML
    private TextField petCharTablePetHeightTextFiled;

    @FXML
    private TextField PetCharTablePetWeightTextFiled;

    @FXML
    private TextField petCharTablePetLengthTextFiled;

    @FXML
    private TableView<PetCharacteristics> petCharTableView;

    @FXML
    private TableColumn<PetCharacteristics, String> petCharacteristicIdColumn;

    @FXML
    private TableColumn<PetCharacteristics, String> petHeightColumn;

    @FXML
    private TableColumn<PetCharacteristics, String> petWeightColumn;

    @FXML
    private TableColumn<PetCharacteristics, String> petLengthColumn;


    @FXML
    void insertIntoPetCharacteristics(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.petcharacteristic (PetCharID,petHeight,petWeight,petLength)" +
                " VALUES('"+petCharTablePetCharIdTextFiled.getText()+"','"+petCharTablePetHeightTextFiled.getText()+"','"+PetCharTablePetWeightTextFiled.getText()+"','"+petCharTablePetLengthTextFiled.getText()+"')";
        executor(query);
        showPetCharacteristics();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showProvides();
        showService();
        showVet();


    }

    @FXML
    void updateFromPetCharacteristics(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.petcharacteristic SET petHeight='"+petCharTablePetHeightTextFiled.getText()+"',petWeight='"+PetCharTablePetWeightTextFiled.getText()+"',petLength='"+petCharTablePetLengthTextFiled.getText()+"'"+" WHERE PetCharID='"+petCharTablePetCharIdTextFiled.getText()+"';";
        executor(query);
        showPetCharacteristics();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showProvides();
        showService();
        showVet();

    }
    @FXML
    void deleteFromPetCharacteristics(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.petcharacteristic" +
                " WHERE PetCharID='"+petCharTablePetCharIdTextFiled.getText()+"'";
        executor(query);
        showPetCharacteristics();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showProvides();
        showService();
        showVet();

    }




    public ObservableList<PetCharacteristics> getPetCharacteristics(){
        ObservableList<PetCharacteristics> petCharacteristicsList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.petcharacteristic";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                petCharacteristicsList.add(new PetCharacteristics (rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petCharacteristicsList ;
    }


    public void showPetCharacteristics() {
        ObservableList<PetCharacteristics> list = getPetCharacteristics();

        petCharacteristicIdColumn.setCellValueFactory(new PropertyValueFactory<>("petCharTablePetCharId"));
        petHeightColumn.setCellValueFactory(new PropertyValueFactory<>("petCharTablePetHeight"));
        petWeightColumn.setCellValueFactory(new PropertyValueFactory<>("PetCharTablePetWeight"));
        petLengthColumn.setCellValueFactory(new PropertyValueFactory<>("petCharTablePetLength"));
        petCharTableView.setItems(list);
    }


    /** Provides **/
    @FXML
    private TextField providesTableVetIdTextArea;

    @FXML
    private TextField providesTableServiceIdTextArea;

    @FXML
    private TableView<Provides> providesTableView;

    @FXML
    private TableColumn<Provides, String> providesTableVetIdColumn;

    @FXML
    private TableColumn<Provides, String> providesTableServiceIdColumn;

    @FXML
    void deleteInToProvides(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.provides" +
                " WHERE vetID='"+providesTableVetIdTextArea.getText()+"'";
        executor(query);
        showProvides();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showService();
        showVet();

    }

    @FXML
    void insertInToProvides(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.provides (vetID,serviceID)" +
                " VALUES('"+providesTableVetIdTextArea.getText()+"','"+providesTableServiceIdTextArea.getText()+"')";
        executor(query);
        showProvides();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showService();
        showVet();

    }

    @FXML
    void updateInToProvides(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.provides SET serviceID='"+providesTableVetIdTextArea.getText()+"'"+" WHERE serviceID='"+providesTableServiceIdTextArea.getText()+"';";
        executor(query);
        showProvides();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showService();
        showVet();

    }

    public ObservableList<Provides> getProvidesList(){
        ObservableList<Provides> providesList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.provides";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                providesList.add(new Provides(rs.getString(1),
                        rs.getString(2)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providesList ;
    }



    private void showProvides() {
        ObservableList<Provides> list = getProvidesList();

        providesTableVetIdColumn.setCellValueFactory(new PropertyValueFactory<>("providesTableVetId"));
        providesTableServiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("providesTableServiceId"));
        providesTableView.setItems(list);
    }


    /**Service**/
    @FXML
    private TextField serviceTableServiceIdTextField;

    @FXML
    private TextField serviceTableCustomerIdTextField;

    @FXML
    private TextField serviceTableReservationDateTextField;

    @FXML
    private TextField serviceTableServiceTypeTextField;

    @FXML
    private TextField serviceTableServiceDescTextField;

    @FXML
    private TableView<Service> serviceTableView;

    @FXML
    private TableColumn<Service, String> sTableServiceIDColumn;

    @FXML
    private TableColumn<Service, String> sTableCustIdColumn;

    @FXML
    private TableColumn<Service, String> sTableRdateColumn;

    @FXML
    private TableColumn<Service, String> sTableServiceTypeColumn;

    @FXML
    private TableColumn<Service, String> sTableServiceDescColumn;


    @FXML
    void insertIntoService(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.service (serviceID,custID,rDate,serviceType,serviceDesp)" +
                " VALUES('"+serviceTableServiceIdTextField.getText()+"','"+serviceTableCustomerIdTextField.getText()+"','"+serviceTableReservationDateTextField.getText()+"','"+serviceTableServiceTypeTextField.getText()+"','"+serviceTableServiceDescTextField.getText()+"')";
        executor(query);
        showService();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showVet();

    }

    @FXML
    void updateFromService(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.service SET custID='"+serviceTableCustomerIdTextField.getText()+"',rDate='"+serviceTableReservationDateTextField.getText()+"',serviceType='"+serviceTableServiceTypeTextField.getText()+"',serviceDesp='"+serviceTableServiceDescTextField.getText()+"'"+" WHERE serviceID='"+serviceTableServiceIdTextField.getText()+"';";
        executor(query);
        showService();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showVet();

    }
    @FXML
    void deleteFromService(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.service" +
                " WHERE serviceID='"+serviceTableServiceIdTextField.getText()+"'";
        executor(query);
        showService();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showVet();

    }




    public ObservableList<Service> getService(){
        ObservableList<Service> serviceList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.service";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                serviceList.add(new Service (rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceList ;
    }


    public void showService() {
        ObservableList<Service> list = getService();

        sTableServiceIDColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTableServiceId"));
        sTableCustIdColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTableCustId"));
        sTableRdateColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTableRdate"));
        sTableServiceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTableServiceType"));
        sTableServiceDescColumn.setCellValueFactory(new PropertyValueFactory<>("serviceTableServiceDesc"));
        serviceTableView.setItems(list);
    }

    /**vet**/

    @FXML
    private TextField vetTableVetIdTextFiled;

    @FXML
    private TextField vetTableFnameTextFiled;

    @FXML
    private TextField vetTableLnameIdTextFiled;

    @FXML
    private TextField vetTableVetEmailTextFiled;

    @FXML
    private TextField vetTableVetAddressTextFiled;

    @FXML
    private TextField vetTableVetWorkPhoneTextFiled;

    @FXML
    private TextField vetTableVetPositionTextFiled;

    @FXML
    private TextField vetTableVetQualificationTextFiled;

    @FXML
    private TableView<Vet> vetTableView;

    @FXML
    private TableColumn<Vet, String> vTableVetIdColumn;

    @FXML
    private TableColumn<Vet, String> vTableFnameColumn;

    @FXML
    private TableColumn<Vet, String> vTableLnameColumn;

    @FXML
    private TableColumn<Vet, String> vTableVetEmailColumn;

    @FXML
    private TableColumn<Vet, String> vTableVetAddressColumn;

    @FXML
    private TableColumn<Vet, String> vTableVetWorkPhoneColumn;

    @FXML
    private TableColumn<Vet, String> vTableVetPositionColumn;

    @FXML
    private TableColumn<Vet, String> vTableVetQualificationColumn;

    @FXML
    void insertInToVet(ActionEvent event) {
        String query = "INSERT INTO veterinary_management_system.vet (vetID,fName,lName,vetEmail,vetAddress,vetWorkPhone,vetPosition,vetQualification)" +
                " VALUES('"+vetTableVetIdTextFiled.getText()+"','"+vetTableFnameTextFiled.getText()+"','"+vetTableLnameIdTextFiled.getText()+"','"+vetTableVetEmailTextFiled.getText()+"','"+vetTableVetAddressTextFiled.getText()+"','"+vetTableVetWorkPhoneTextFiled.getText()+"','"+vetTableVetPositionTextFiled.getText()+"','"+vetTableVetQualificationTextFiled.getText()+"')";
        executor(query);
        showVet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();

    }

    @FXML
    void updateFromVet(ActionEvent event) {
        String query =  "UPDATE veterinary_management_system.vet SET fName='"+vetTableFnameTextFiled.getText()+"',lName='"+vetTableLnameIdTextFiled.getText()+"',vetEmail='"+vetTableVetEmailTextFiled.getText()+"',vetAddress='"+vetTableVetAddressTextFiled.getText()+"',vetWorkPhone='"+vetTableVetWorkPhoneTextFiled.getText()+"',vetPosition='"+vetTableVetPositionTextFiled.getText()+"',vetQualification='"+vetTableVetQualificationTextFiled.getText()+"'"+" WHERE vetID='"+vetTableVetIdTextFiled.getText()+"';";
        executor(query);
        showVet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();


    }
    @FXML
    void deleteFromVet(ActionEvent event) {
        String query = "DELETE FROM veterinary_management_system.vet" +
                " WHERE vetID='"+vetTableVetIdTextFiled.getText()+"'";
        executor(query);
        showVet();
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        

    }

    public ObservableList<Vet> getVet(){
        ObservableList<Vet> petList = FXCollections.observableArrayList();

        Connection connection = Connect.getConnection();
        String query = "SELECT * FROM veterinary_management_system.vet";
        Statement st;
        ResultSet rs;

        try {
            assert connection != null;
            st = connection.createStatement();
            rs = st.executeQuery(query);


            while(rs.next()) {

                petList.add(new Vet(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petList ;
    }



    private void showVet() {
        ObservableList<Vet> list = getVet();

        vTableVetIdColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetId"));
        vTableFnameColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableFname"));
        vTableLnameColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableLname"));
        vTableVetEmailColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetEmail"));
        vTableVetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetAdress"));
        vTableVetWorkPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetWorkPhone"));
        vTableVetPositionColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetPosition"));
        vTableVetQualificationColumn.setCellValueFactory(new PropertyValueFactory<>("vetTableVetQualification"));
        vetTableView.setItems(list);
    }

    @FXML
    void ChangeUserButtonClicked(ActionEvent event) throws IOException {

        Parent adminParent = FXMLLoader.load(getClass().getResource("selectUser.fxml"));
        Scene ChangeUserScene = new Scene(adminParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ChangeUserScene);
        window.show();

    }






    public void executor(String query) {
        Connection conn = Connect.getConnection();
        Statement st;
        try {
            assert conn != null;
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showCustomers();
        showCustomerPhoneNumber();
        showInvoice();
        showNeeds();
        showPet();
        showPetCharacteristics();
        showProvides();
        showService();
        showVet();

    }
}
