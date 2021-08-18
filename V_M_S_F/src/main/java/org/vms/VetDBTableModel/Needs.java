package org.vms.VetDBTableModel;
public class Needs {
    String needsTableCustomerPetId;
    String needsTablePetServiceId;

    public Needs(String needsTableCustomerPetId, String needsTablePetServiceId) {
        this.needsTableCustomerPetId = needsTableCustomerPetId;
        this.needsTablePetServiceId = needsTablePetServiceId;
    }

    public String getNeedsTableCustomerPetId() {
        return needsTableCustomerPetId;
    }

    public void setNeedsTableCustomerPetId(String needsTableCustomerPetId) {
        this.needsTableCustomerPetId = needsTableCustomerPetId;
    }

    public String getNeedsTablePetServiceId() {
        return needsTablePetServiceId;
    }

    public void setNeedsTablePetServiceId(String needsTablePetServiceId) {
        this.needsTablePetServiceId = needsTablePetServiceId;
    }
}
