package Model;

public class Colleges extends  University {
    private int idCollege;
    private int idUniversity;
    private String collegeName;

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getIdCollege() {
        return idCollege;
    }

    public void setIdCollege(int idCollege) {
        this.idCollege = idCollege;
    }
}
