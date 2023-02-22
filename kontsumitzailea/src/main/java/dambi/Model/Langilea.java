package dambi.Model;

import java.util.Date;
import java.util.List;

public class Langilea {

    private String email;

    private String izena;

    private String erabiltzailea;

    private Date jaiotzadata;

    private int taldea;

    private List<Partida> partidak;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public Date getJaiotzadata() {
        return jaiotzadata;
    }

    public void setJaiotzadata(Date jaiotzadata) {
        this.jaiotzadata = jaiotzadata;
    }

    public Integer getTaldea() {
        return taldea;
    }

    public void setTaldea(Integer taldea) {
        this.taldea = taldea;
    }

    public List<Partida> getPartidak() {
        return partidak;
    }

    public void setPartidak(List<Partida> partidak) {
        this.partidak = partidak;
    }

}
