package org.vms.VetDBTableModel;

public class Service {
    String serviceTableServiceId;
    String serviceTableCustId;
    String serviceTableRdate;
    String serviceTableServiceType;
    String serviceTableServiceDesc;

    public Service(String serviceTableServiceId, String serviceTableCustId, String serviceTableRdate, String serviceTableServiceType, String serviceTableServiceDesc) {
        this.serviceTableServiceId = serviceTableServiceId;
        this.serviceTableCustId = serviceTableCustId;
        this.serviceTableRdate = serviceTableRdate;
        this.serviceTableServiceType = serviceTableServiceType;
        this.serviceTableServiceDesc = serviceTableServiceDesc;
    }

    public String getServiceTableServiceId() {
        return serviceTableServiceId;
    }

    public void setServiceTableServiceId(String serviceTableServiceId) {
        this.serviceTableServiceId = serviceTableServiceId;
    }

    public String getServiceTableCustId() {
        return serviceTableCustId;
    }

    public void setServiceTableCustId(String serviceTableCustId) {
        this.serviceTableCustId = serviceTableCustId;
    }

    public String getServiceTableRdate() {
        return serviceTableRdate;
    }

    public void setServiceTableRdate(String serviceTableRdate) {
        this.serviceTableRdate = serviceTableRdate;
    }

    public String getServiceTableServiceType() {
        return serviceTableServiceType;
    }

    public void setServiceTableServiceType(String serviceTableServiceType) {
        this.serviceTableServiceType = serviceTableServiceType;
    }

    public String getServiceTableServiceDesc() {
        return serviceTableServiceDesc;
    }

    public void setServiceTableServiceDesc(String serviceTableServiceDesc) {
        this.serviceTableServiceDesc = serviceTableServiceDesc;
    }
}

