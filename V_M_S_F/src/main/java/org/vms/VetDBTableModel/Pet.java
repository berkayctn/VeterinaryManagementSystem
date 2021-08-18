package org.vms.VetDBTableModel;

public class Pet {
    String petTablePetId;
    String petTableCustId;
    String petTablePetCharId;
    String petTablePetBirthDate;
    String petTablePetGender;
    String petTablePetType;
    String petTableAdoptionDate;

    public Pet(String petTablePetId, String petTableCustId, String petTablePetCharId, String petTablePetBirthDate, String petTablePetGender, String petTablePetType, String petTableAdoptionDate) {
        this.petTablePetId = petTablePetId;
        this.petTableCustId = petTableCustId;
        this.petTablePetCharId = petTablePetCharId;
        this.petTablePetBirthDate = petTablePetBirthDate;
        this.petTablePetGender = petTablePetGender;
        this.petTablePetType = petTablePetType;
        this.petTableAdoptionDate = petTableAdoptionDate;
    }

    public String getPetTablePetId() {
        return petTablePetId;
    }

    public void setPetTablePetId(String petTablePetId) {
        this.petTablePetId = petTablePetId;
    }

    public String getPetTableCustId() {
        return petTableCustId;
    }

    public void setPetTableCustId(String petTableCustId) {
        this.petTableCustId = petTableCustId;
    }

    public String getPetTablePetCharId() {
        return petTablePetCharId;
    }

    public void setPetTablePetCharId(String petTablePetCharId) {
        this.petTablePetCharId = petTablePetCharId;
    }

    public String getPetTablePetBirthDate() {
        return petTablePetBirthDate;
    }

    public void setPetTablePetBirthDate(String petTablePetBirthDate) {
        this.petTablePetBirthDate = petTablePetBirthDate;
    }

    public String getPetTablePetGender() {
        return petTablePetGender;
    }

    public void setPetTablePetGender(String petTablePetGender) {
        this.petTablePetGender = petTablePetGender;
    }

    public String getPetTablePetType() {
        return petTablePetType;
    }

    public void setPetTablePetType(String petTablePetType) {
        this.petTablePetType = petTablePetType;
    }

    public String getPetTableAdoptionDate() {
        return petTableAdoptionDate;
    }

    public void setPetTableAdoptionDate(String petTableAdoptionDate) {
        this.petTableAdoptionDate = petTableAdoptionDate;
    }
}
