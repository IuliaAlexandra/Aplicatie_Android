package com.example.iuliapopa.bac_androidapp.com.example.pojo;

/**
 * Created by Ioana.Nenciu on 21.06.2017.
 */

public class DisciplinaSpecializarePOJO {

    private Integer idSpec;
    private Integer idDisc;
    private boolean obligatorie;
    private boolean moderna;
    private boolean materna;

    public Integer getIdSpec() {
        return idSpec;
    }
    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }
    public Integer getIdDisc() {
        return idDisc;
    }
    public void setIdDisc(Integer idDisc) {
        this.idDisc = idDisc;
    }
    public boolean isObligatorie() {
        return obligatorie;
    }
    public void setObligatorie(boolean obligatorie) {
        this.obligatorie = obligatorie;
    }
    public boolean isModerna() {
        return moderna;
    }
    public void setModerna(boolean moderna) {
        this.moderna = moderna;
    }
    public boolean isMaterna() {
        return materna;
    }
    public void setMaterna(boolean materna) {
        this.materna = materna;
    }
}
