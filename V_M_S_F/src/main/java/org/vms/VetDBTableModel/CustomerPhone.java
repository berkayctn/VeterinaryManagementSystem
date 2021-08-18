package org.vms.VetDBTableModel;

public class CustomerPhone {
    String custId;
    String customerPhoneNumber;

    public CustomerPhone(String custId, String customerPhoneNumber) {
        this.custId = custId;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
