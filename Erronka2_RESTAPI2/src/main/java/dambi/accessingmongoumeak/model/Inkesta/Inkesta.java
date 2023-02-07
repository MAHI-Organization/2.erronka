package dambi.accessingmongoumeak.model.Inkesta;

import java.util.List;

import dambi.accessingmongoumeak.model.Jokoa;

public class Inkesta {

    private String erabiltzailea;
    private Jokoa jokoa;
    private List<String> galderak;

    public Inkesta(){
        this.erabiltzailea = "";
        this.jokoa = null;
        this.galderak = null;
    }

    public Inkesta(String erabiltzailea,Jokoa jokoa,List<String> galderenErantzunak){
        this.erabiltzailea = erabiltzailea;
        this.jokoa = jokoa;
        this.galderak = galderenErantzunak;
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

    public List<String> getGalderak() {
        return galderak;
    }

    public void setGalderak(List<String> galderak) {
        this.galderak = galderak;
    }

    @Override
    public String toString() {
        return "Inkesta [erabiltzailea=" + erabiltzailea + ", jokoa=" + jokoa + ", galderak=" + galderak + "]";
    }

    

}
