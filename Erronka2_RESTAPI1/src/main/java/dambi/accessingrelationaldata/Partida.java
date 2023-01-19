package dambi.accessingrelationaldata;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user")
    private String user;

    @Column(name = "puntuazioa")
    private Float puntuazioa;

    @Column(name = "data")

    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(Float puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne()
    @JoinColumn(name = "langilea")
    private Langilea langilea;

}
