package dambi.Model;

import java.util.Date;

public class Partida {
    private int id;
    private Langilea langilea;
    private Float puntuazioa;
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(Float puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public Langilea getLangilea() {
        return langilea;
    }
    public void setLangilea(Langilea langilea){
        this.langilea = langilea;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
