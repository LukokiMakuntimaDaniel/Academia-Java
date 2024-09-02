package Model;

public class Designations extends Modules {
    public int idDesignation;
    public String nameDesignation;
    public String abbreviation;
    public int idModule;

    public int getIdDesignation() {
        return idDesignation;
    }

    public void setIdDesignation(int idDesignation) {
        this.idDesignation = idDesignation;
    }

    public String getNameDesignation() {
        return nameDesignation;
    }

    public void setNameDesignation(String nameDesignation) {
        this.nameDesignation = nameDesignation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
}
