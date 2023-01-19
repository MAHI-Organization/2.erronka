package dambi.accessingrelationaldata;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// This tells Hibernate to make a table out of this class
@Entity
@Table(name="Langilea")
public class Langilea {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String email;

	private String izena;

	private String user;

	private Date jaiotzadata;

	private int taldea;

	@OneToMany(mappedBy = "langilea", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Partida> partidak = new ArrayList<>();

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
}
