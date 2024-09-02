package Model;

public class Trainers extends Users {
    private int idTrainer;
    private int idUser;
    private int trainerNumber;
    private int institutionInserted;

    public int getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getTrainerNumber() {
        return trainerNumber;
    }

    public void setTrainerNumber(int trainerNumber) {
        this.trainerNumber = trainerNumber;
    }

    public int getInstitutionInserted() {
        return institutionInserted;
    }

    public void setInstitutionInserted(int institutionInserted) {
        this.institutionInserted = institutionInserted;
    }
}
