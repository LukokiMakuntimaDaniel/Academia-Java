package Model;

public class Secretars extends Users {

    private int idSecretary;
    private int idUser;
    private int numberSecretary;
    private String courseTaken;


    public int getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(int idSecretary) {
        this.idSecretary = idSecretary;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNumberSecretary() {
        return numberSecretary;
    }

    public void setNumberSecretary(int numberSecretary) {
        this.numberSecretary = numberSecretary;
    }

    public String getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String courseTaken) {
        this.courseTaken = courseTaken;
    }
}
