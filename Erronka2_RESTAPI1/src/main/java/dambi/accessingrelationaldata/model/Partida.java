package dambi.accessingrelationaldata.model;

import java.io.Serial;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity(name = "partida")
@Table(name = "partida_partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "erabiltzailea")
	//@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "erabiltzailea_name", referencedColumnName = "erabiltzailea", foreignKey = @ForeignKey(
        name = "fk_partida",
        foreignKeyDefinition = "FOREIGN KEY (erabiltzailea)\r\n" +
                "REFERENCES public.\"langilea\"(erabiltzailea) MATCH SIMPLE\r\n" +
                "ON UPDATE CASCADE\r\n" + 
                "ON DELETE CASCADE",
                value = ConstraintMode.CONSTRAINT
    ))
    private Langilea langilea;
 
 
    @Column(name = "puntuazioa")
    private float puntuazioa;

    @Column(name = "data")
    private Date data;

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(float puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public Langilea getLangilea() {
        return langilea;
    }
    public void setLangilea(Langilea langilea){
        this.langilea = langilea;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
