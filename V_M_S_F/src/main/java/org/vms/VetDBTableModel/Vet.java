package org.vms.VetDBTableModel;

public class Vet {
    String vetTableVetId;
    String vetTableFname;
    String vetTableLname;
    String vetTableVetEmail;
    String vetTableVetAdress;
    String vetTableVetWorkPhone;
    String vetTableVetPosition;
    String vetTableVetQualification;


    public Vet(String vetTableVetId, String vetTableFname, String vetTableLname, String vetTableVetEmail, String vetTableVetAdress, String vetTableVetWorkPhone, String vetTableVetPosition, String vetTableVetQualification) {
        this.vetTableVetId = vetTableVetId;
        this.vetTableFname = vetTableFname;
        this.vetTableLname = vetTableLname;
        this.vetTableVetEmail = vetTableVetEmail;
        this.vetTableVetAdress = vetTableVetAdress;
        this.vetTableVetWorkPhone = vetTableVetWorkPhone;
        this.vetTableVetPosition = vetTableVetPosition;
        this.vetTableVetQualification = vetTableVetQualification;
    }

    public String getVetTableVetId() {
        return vetTableVetId;
    }

    public void setVetTableVetId(String vetTableVetId) {
        this.vetTableVetId = vetTableVetId;
    }

    public String getVetTableFname() {
        return vetTableFname;
    }

    public void setVetTableFname(String vetTableFname) {
        this.vetTableFname = vetTableFname;
    }

    public String getVetTableLname() {
        return vetTableLname;
    }

    public void setVetTableLname(String vetTableLname) {
        this.vetTableLname = vetTableLname;
    }

    public String getVetTableVetEmail() {
        return vetTableVetEmail;
    }

    public void setVetTableVetEmail(String vetTableVetEmail) {
        this.vetTableVetEmail = vetTableVetEmail;
    }

    public String getVetTableVetAdress() {
        return vetTableVetAdress;
    }

    public void setVetTableVetAdress(String vetTableVetAdress) {
        this.vetTableVetAdress = vetTableVetAdress;
    }

    public String getVetTableVetWorkPhone() {
        return vetTableVetWorkPhone;
    }

    public void setVetTableVetWorkPhone(String vetTableVetWorkPhone) {
        this.vetTableVetWorkPhone = vetTableVetWorkPhone;
    }

    public String getVetTableVetPosition() {
        return vetTableVetPosition;
    }

    public void setVetTableVetPosition(String vetTableVetPosition) {
        this.vetTableVetPosition = vetTableVetPosition;
    }

    public String getVetTableVetQualification() {
        return vetTableVetQualification;
    }

    public void setVetTableVetQualification(String vetTableVetQualification) {
        this.vetTableVetQualification = vetTableVetQualification;
    }
}