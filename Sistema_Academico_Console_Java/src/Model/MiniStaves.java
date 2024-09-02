package Model;

import java.sql.Timestamp;

public class MiniStaves {
    private int idMiniStave;
    private int idStudant;
    private int idTrainer;
    private int idModule;
    private int idDesignation;
    private String note;
    private String descrition;
    private String signature;
    private Timestamp dateStave;

    public int getIdStudant() {
        return idStudant;
    }

    public void setIdStudant(int idStudant) {
        this.idStudant = idStudant;
    }

    public int getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdDesignation() {
        return idDesignation;
    }

    public void setIdDesignation(int idDesignation) {
        this.idDesignation = idDesignation;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Timestamp getDateStave() {
        return dateStave;
    }

    public void setDateStave(Timestamp dateStave) {
        this.dateStave = dateStave;
    }
}
