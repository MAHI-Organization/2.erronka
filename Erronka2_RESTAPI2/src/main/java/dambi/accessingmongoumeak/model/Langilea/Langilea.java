package dambi.accessingmongoumeak.model.Langilea;

import java.sql.Date;
import java.util.List;

import dambi.accessingmongoumeak.model.Partida.Partida;


public class Langilea {

	private String email;
	private String izena;
	private String erabiltzailea;
	private String jaiotzadata;
	private int taldea;
	private List<Partida> partidak;
	private String pasahitza;

	public Langilea() {        
        this.izena = "";

    }
    public Langilea(String izena){  
        this.izena = izena;
		
    }

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

	public String getJaiotzadata() {
		return jaiotzadata;
	}

	public void setJaiotzadata(String jaiotzadata) {
		this.jaiotzadata = jaiotzadata;
	}

	public int getTaldea() {
		return taldea;
	}

	public void setTaldea(int taldea) {
		this.taldea = taldea;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	@Override
	public String toString() {
		return "Langilea [email=" + email + ", izena=" + izena + ", erabiltzailea=" + erabiltzailea + ", jaiotzadata="
				+ jaiotzadata + ", taldea=" + taldea + ", pasahitza=" + pasahitza + "]";
	}

	public List<Partida> getPartidak() {
		return partidak;
	}
	public void setPartidak(List<Partida> partidak) {
		this.partidak = partidak;
	}

}
