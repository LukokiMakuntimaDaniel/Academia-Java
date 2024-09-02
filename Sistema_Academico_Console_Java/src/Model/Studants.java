package Model;

public class Studants extends Users {
    private int idStudant;
    private int idUser;
    private int studentNumber;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getIdStudant() {
        return idStudant;
    }

    public void setIdStudant(int idStudant) {
        this.idStudant = idStudant;
    }
}
