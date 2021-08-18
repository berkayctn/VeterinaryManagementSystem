package org.vms.VetDBTableModel;

public class Customer {

    String custId;
    String firstName;
    String lastName;

    public Customer(String custId, String firstName, String lastName) {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custID) {
        this.custId = custID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }






}
