package dambi.accessingmongoumeak.model.Balorazioa;

public class Balorazioa {

    private String erabiltzailea;
    private String jokoa;
    private float balorazioa;

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getJokoa() {
        return jokoa;
    }

    public void setJokoa(String jokoa) {
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
