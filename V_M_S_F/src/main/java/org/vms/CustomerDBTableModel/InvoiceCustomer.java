package org.vms.CustomerDBTableModel;

public class InvoiceCustomer {
    String myInvoiceYourId;
    String paymentMethodCustomer;
    String paymentDateCustomer;
    String paymentCostCustomer;

    public InvoiceCustomer(String myInvoiceYourId, String paymentMethodCustomer, String paymentDateCustomer, String paymentCostCustomer) {
        this.myInvoiceYourId = myInvoiceYourId;
        this.paymentMethodCustomer = paymentMethodCustomer;
        this.paymentDateCustomer = paymentDateCustomer;
        this.paymentCostCustomer = paymentCostCustomer;
    }

    public String getMyInvoiceYourId() {
        return myInvoiceYourId;
    }

    public void setMyInvoiceYourId(String myInvoiceYourId) {
        this.myInvoiceYourId = myInvoiceYourId;
    }

    public String getPaymentMethodCustomer() {
        return paymentMethodCustomer;
    }

    public void setPaymentMethodCustomer(String paymentMethodCustomer) {
        this.paymentMethodCustomer = paymentMethodCustomer;
    }

    public String getPaymentDateCustomer() {
        return paymentDateCustomer;
    }

    public void setPaymentDateCustomer(String paymentDateCustomer) {
        this.paymentDateCustomer = paymentDateCustomer;
    }

    public String getPaymentCostCustomer() {
        return paymentCostCustomer;
    }

    public void setPaymentCostCustomer(String paymentCostCustomer) {
        this.paymentCostCustomer = paymentCostCustomer;
    }
}
