package dambi.accessingmongoumeak.model.Partida;

import java.sql.Date;


public class Partida {

	private int _id;
	private String erabiltzailea;
	private float puntuazioa;
	private Date data;
	private String jokoa;

	public int getId() {
		return _id;

	}

	public void setId(int id) {
		this._id = id;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
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

	public String getJokoa() {
		return jokoa;
	}

	public void setJokoa(String jokoa) {
		this.jokoa = jokoa;
	}

	@Override
	public String toString() {
		return "Partida [_id=" + _id + ", erabiltzailea=" + erabiltzailea + ", puntuazioa=" + puntuazioa + ", data="
				+ data + ", jokoa=" + jokoa + "]";
	}

}
