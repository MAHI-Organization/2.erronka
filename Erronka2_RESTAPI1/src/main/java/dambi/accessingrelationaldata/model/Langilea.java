package dambi.accessingrelationaldata.model;

import java.sql.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// This tells Hibernate to make a table out of this class
@Entity
@Table(name = "langilea")
public class Langilea {

	private String email;

	private String izena;
	@Id
	private String erabiltzailea;

	private Date jaiotzadata;

	private int taldea;

	
	@OneToMany(mappedBy = "langilea", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
