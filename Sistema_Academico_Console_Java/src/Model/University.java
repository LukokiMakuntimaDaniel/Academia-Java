package Model;

import java.util.Date;

public class University {
    private int idUniversity;
    private String UniversityName;
    private Date foundationData;

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public Date getFoundationData() {
        return foundationData;
    }

    public void setFoundationData(Date foundationData) {
        this.foundationData = foundationData;
    }
}
