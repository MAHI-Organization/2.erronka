package dambi.accessingmongoumeak.model.Inkesta;

public class Inkesta {

    private String erabiltzailea;
    private String lehenengoGaldera;
    private String bigarrenGaldera;
    private String hirugarrenGaldera;
    private String laugarrenGaldera;

    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getLehenengoGaldera() {
        return lehenengoGaldera;
    }

    public void setLehenengoGaldera(String lehenengoGaldera) {
        this.lehenengoGaldera = lehenengoGaldera;
    }

    public String getBigarrenGaldera() {
        return bigarrenGaldera;
    }

    public void setBigarrenGaldera(String bigarrenGaldera) {
        this.bigarrenGaldera = bigarrenGaldera;
    }

    public String getHirugarrenGaldera() {
        return hirugarrenGaldera;
    }

    public void setHirugarrenGaldera(String hirugarrenGaldera) {
        this.hirugarrenGaldera = hirugarrenGaldera;
    }

    public String getLaugarrenGaldera() {
        return laugarrenGaldera;
    }

    public void setLaugarrenGaldera(String laugarrenGaldera) {
        this.laugarrenGaldera = laugarrenGaldera;
    }

    @Override
    public String toString() {
        return "Inkesta [erabiltzailea=" + erabiltzailea + ", lehenengoGaldera=" + lehenengoGaldera
                + ", bigarrenGaldera=" + bigarrenGaldera + ", hirugarrenGaldera=" + hirugarrenGaldera
                + ", laugarrenGaldera=" + laugarrenGaldera + "]";
    }

}
