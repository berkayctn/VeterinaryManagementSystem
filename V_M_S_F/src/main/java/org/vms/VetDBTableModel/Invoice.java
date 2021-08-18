package org.vms.VetDBTableModel;

public class Invoice {
    String invoiceId;
    String serviceId;
    String customerId;
    String paymentMethod;
    String paymentDate;
    String cost;


    public Invoice( String invoiceId, String serviceId, String customerId,String paymentMethod, String paymentDate, String cost) {
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.cost = cost;
        this.customerId=customerId;
    }


    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
