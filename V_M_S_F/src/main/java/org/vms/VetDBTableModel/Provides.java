package org.vms.VetDBTableModel;

public class Provides {
    String providesTableVetId;
    String providesTableServiceId;

    public Provides(String providesTableVetId, String providesTableServiceId) {
        this.providesTableVetId = providesTableVetId;
        this.providesTableServiceId = providesTableServiceId;
    }

    public String getProvidesTableVetId() {
        return providesTableVetId;
    }

    public void setProvidesTableVetId(String providesTableVetId) {
        this.providesTableVetId = providesTableVetId;
    }

    public String getProvidesTableServiceId() {
        return providesTableServiceId;
    }

    public void setProvidesTableServiceId(String providesTableServiceId) {
        this.providesTableServiceId = providesTableServiceId;
    }
}
