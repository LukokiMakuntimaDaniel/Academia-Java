package Model;

public class Administrators extends Users {
    private int idAdmin;
    private int idUser;
    private int numberAdmin;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getNumberAdmin() {
        return numberAdmin;
    }

    public void setNumberAdmin(int numberAdmin) {
        this.numberAdmin = numberAdmin;
    }
}
