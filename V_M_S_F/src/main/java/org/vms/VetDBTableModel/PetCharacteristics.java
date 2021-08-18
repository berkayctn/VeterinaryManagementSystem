package org.vms.VetDBTableModel;

public class PetCharacteristics {
    String petCharTablePetCharId;
    String petCharTablePetHeight;
    String PetCharTablePetWeight;
    String petCharTablePetLength;

    public PetCharacteristics(String petCharTablePetCharId, String petCharTablePetHeight, String petCharTablePetWeight, String petCharTablePetLength) {
        this.petCharTablePetCharId = petCharTablePetCharId;
        this.petCharTablePetHeight = petCharTablePetHeight;
        PetCharTablePetWeight = petCharTablePetWeight;
        this.petCharTablePetLength = petCharTablePetLength;
    }

    public String getPetCharTablePetCharId() {
        return petCharTablePetCharId;
    }

    public void setPetCharTablePetCharId(String petCharTablePetCharId) {
        this.petCharTablePetCharId = petCharTablePetCharId;
    }

    public String getPetCharTablePetHeight() {
        return petCharTablePetHeight;
    }

    public void setPetCharTablePetHeight(String petCharTablePetHeight) {
        this.petCharTablePetHeight = petCharTablePetHeight;
    }

    public String getPetCharTablePetWeight() {
        return PetCharTablePetWeight;
    }

    public void setPetCharTablePetWeight(String petCharTablePetWeight) {
        PetCharTablePetWeight = petCharTablePetWeight;
    }

    public String getPetCharTablePetLength() {
        return petCharTablePetLength;
    }

    public void setPetCharTablePetLength(String petCharTablePetLength) {
        this.petCharTablePetLength = petCharTablePetLength;
    }
}
