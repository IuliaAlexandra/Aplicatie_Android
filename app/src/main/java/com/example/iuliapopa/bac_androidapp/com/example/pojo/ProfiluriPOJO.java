package com.example.iuliapopa.bac_androidapp.com.example.pojo;

import java.util.List;

/**
 * Created by Ioana.Nenciu on 21.06.2017.
 */

public class ProfiluriPOJO {
    List<ProfilPOJO> profiluri;

    public List<ProfilPOJO> getProfiluri() {
        return profiluri;
    }

    public void setProfiluri(List<ProfilPOJO> profiluri) {
        this.profiluri = profiluri;
    }

    @Override
    public String toString() {
        return "ProfiluriPOJO [profiluri=" + profiluri + "]";
    }


}
