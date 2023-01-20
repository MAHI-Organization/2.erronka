package dambi.accessingmongoumeak.model;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class Langilea {
	
	private String email; 
	private String izena;
	private String erabiltzailea;
	private Date jaiotzadata;
	private int taldea;
	

	
	
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

	public int getTaldea() {
		return taldea;
	}

	public void setTaldea(int taldea) {
		this.taldea = taldea;
	}

	@Override
	public String toString() {
		return "Langilea [email=" + email + ", izena=" + izena + ", erabiltzailea=" + erabiltzailea + ", jaiotzadata="
				+ jaiotzadata + ", taldea=" + taldea + "]";
	}

	
	
}
