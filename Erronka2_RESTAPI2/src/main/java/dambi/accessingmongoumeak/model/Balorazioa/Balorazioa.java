package dambi.accessingmongoumeak.model.Balorazioa;

import dambi.accessingmongoumeak.model.Jokoa;

public class Balorazioa {
    private String erabiltzailea;
    private Jokoa jokoa;
    private float balorazioa;

    public Balorazioa(){
        this.erabiltzailea = "";
        this.jokoa = null;
        this.balorazioa = 0;
    }

    public Balorazioa(String erabiltzailea,Jokoa jokoa,float balorazioa){
        this.erabiltzailea = erabiltzailea;
        this.jokoa = jokoa;
        this.balorazioa = balorazioa;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public Jokoa getJokoa() {
        return jokoa;
    }

    public void setJokoa(Jokoa jokoa) {
        this.jokoa = jokoa;
    }

    public float getBalorazioa() {
        return balorazioa;
    }

    public void setBalorazioa(float balorazioa) {
        this.balorazioa = balorazioa;
    }

    @Override
    public String toString() {
        return "Balorazioa [erabiltzailea=" + erabiltzailea + ", jokoa=" + jokoa + ", balorazioa=" + balorazioa + "]";
    }

}
