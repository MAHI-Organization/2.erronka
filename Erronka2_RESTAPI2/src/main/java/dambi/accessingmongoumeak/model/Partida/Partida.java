package dambi.accessingmongoumeak.model.Partida;




import org.bson.types.ObjectId;

import dambi.accessingmongoumeak.model.Jokoa;
import dambi.accessingmongoumeak.model.Langilea.Langilea;


public class Partida {
	private ObjectId _id;
	private Langilea erabiltzailea;
	private float puntuazioa;
	private String data;
	//private int id;
	private Jokoa jokoa;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/*public int getId() {
		return id;

	}

	public void setId(int id) {
		this.id = id;
	}*/

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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
