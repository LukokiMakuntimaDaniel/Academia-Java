package Model;

import java.util.Date;

public class Registrations {
    private int idRegistration;
    private String courseYouGraduatedFrom;
    private int idCourseToRegister;
    private int idUser;
    private int idUniversity;
    private String typeOfCandidate;
    private String state;
    private String reasonsForApplying;
    private String reasonForChoosingUniversity;
    private String activityInstitution;
    private String workplace;
    private String jobFunction;
    private String paymentMethod;
    private Date dateOfBirth;

    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }

    public String getCourseYouGraduatedFrom() {
        return courseYouGraduatedFrom;
    }

    public void setCourseYouGraduatedFrom(String courseYouGraduatedFrom) {
        this.courseYouGraduatedFrom = courseYouGraduatedFrom;
    }

    public int getIdCourseToRegister() {
        return idCourseToRegister;
    }

    public void setIdCourseToRegister(int idCourseToRegister) {
        this.idCourseToRegister = idCourseToRegister;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getTypeOfCandidate() {
        return typeOfCandidate;
    }

    public void setTypeOfCandidate(String typeOfCandidate) {
        this.typeOfCandidate = typeOfCandidate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReasonsForApplying() {
        return reasonsForApplying;
    }

    public void setReasonsForApplying(String reasonsForApplying) {
        this.reasonsForApplying = reasonsForApplying;
    }

    public String getReasonForChoosingUniversity() {
        return reasonForChoosingUniversity;
    }

    public void setReasonForChoosingUniversity(String reasonForChoosingUniversity) {
        this.reasonForChoosingUniversity = reasonForChoosingUniversity;
    }

    public String getActivityInstitution() {
        return activityInstitution;
    }

    public void setActivityInstitution(String activityInstitution) {
        this.activityInstitution = activityInstitution;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
