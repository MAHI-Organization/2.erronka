package dambi.accessingmongoumeak.model;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class Partida {
	
	private int _id; 
	private String erabiltzailea;
	private float puntuazioa;
	private Date data;
	
	

	
	
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

	@Override
	public String toString() {
		return "Partida [_id=" + _id + ", erabiltzailea=" + erabiltzailea + ", puntuazioa=" + puntuazioa + ", data="
				+ data + "]";
	}




	
	
}
