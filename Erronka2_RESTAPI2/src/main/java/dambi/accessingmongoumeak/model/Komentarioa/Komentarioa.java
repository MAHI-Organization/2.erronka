package dambi.accessingmongoumeak.model.Komentarioa;

import dambi.accessingmongoumeak.model.Jokoa;

public class Komentarioa {

    private int id;
    private String erabiltzailea;
    private Jokoa jokoa;
    private String komentarioa;

    public Komentarioa(){
        this.id = 0;
        this.erabiltzailea = "";
        this.jokoa = null;
        this.komentarioa = "";
    }

    public Komentarioa(int id, String erabiltzailea,String komentarioa, Jokoa jokoa){
        this.id = id;
        this.erabiltzailea = erabiltzailea;
        this.jokoa = jokoa;
        this.komentarioa = komentarioa;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
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

    public String getKomentarioa() {
        return komentarioa;
    }

    public void setKomentarioa(String komentarioa) {
        this.komentarioa = komentarioa;
    }

    @Override
    public String toString() {
        return "Komentarioa [erabiltzailea=" + erabiltzailea + ", jokoa=" + jokoa + ", komentarioa=" + komentarioa
                + "]";
    }

}
