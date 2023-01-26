package dambi.accessingmongoumeak.model;

public class Jokoa {

    private int id;
    private String izena;

    public Jokoa() {

        this.id = 0;
        this.izena = "";

    }
    public Jokoa(int id, String izena){
        this.id = id;
        this.izena = izena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Override
    public String toString() {
        return "Jokoa [id=" + id + ", izena=" + izena + "]";
    }

}
