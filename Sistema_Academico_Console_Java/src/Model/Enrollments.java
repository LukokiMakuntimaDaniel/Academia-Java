package Model;

import java.sql.Timestamp;

public class Enrollments {
   private int idEnrollment;
    private int idClass;
    private int  idUniversity;
    private int  idRegistration;
    private int  idCourse;
    private String academicDegree;
    private Timestamp dateEnrollment;

    public int getIdEnrollment() {
        return idEnrollment;
    }

    public void setIdEnrollment(int idEnrollment) {
        this.idEnrollment = idEnrollment;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Timestamp getDateEnrollment() {
        return dateEnrollment;
    }

    public void setDateEnrollment(Timestamp dateEnrollment) {
        this.dateEnrollment = dateEnrollment;
    }
}
