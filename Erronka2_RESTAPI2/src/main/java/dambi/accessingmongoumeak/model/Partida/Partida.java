package dambi.accessingmongoumeak.model.Partida;

import java.sql.Date;

import dambi.accessingmongoumeak.model.Jokoa;
import dambi.accessingmongoumeak.model.Langilea.Langilea;


public class Partida {

	private int _id;
	private Langilea erabiltzailea;
	private float puntuazioa;
	private Date data;
	private Jokoa jokoa;

	public int getId() {
		return _id;

	}

	public void setId(int id) {
		this._id = id;
	}

	public Langilea getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(Langilea erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public float getPuntuazioa() {
		return puntuazioa;
	}

	public void setPuntuazioa(float puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Jokoa getJokoa() {
		return jokoa;
	}

	public void setJokoa(Jokoa jokoa) {
		this.jokoa = jokoa;
	}

	@Override
	public String toString() {
		return "Partida [_id=" + _id + ", erabiltzailea=" + erabiltzailea + ", puntuazioa=" + puntuazioa + ", data="
				+ data + ", jokoa=" + jokoa + "]";
	}

}
