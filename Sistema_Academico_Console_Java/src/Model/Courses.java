package Model;

public class Courses {
    private int idCourse;
    private String nameCourse;
    private int idCollege;
    private int qtdModule;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getIdCollege() {
        return idCollege;
    }

    public void setIdCollege(int idCollege) {
        this.idCollege = idCollege;
    }

    public int getQtdModule() {
        return qtdModule;
    }

    public void setQtdModule(int qtdModule) {
        this.qtdModule = qtdModule;
    }
}
