package dambi.accessingmongoumeak.model.Komentarioa;

public class Komentarioa {

    private String erabiltzailea;
    private String jokoa;
    private String komentarioa;

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
