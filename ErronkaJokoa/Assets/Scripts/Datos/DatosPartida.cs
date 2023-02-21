using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[Serializable]
public class DatosPartida
{
    public int id;
    public int puntuazioa;
    public DateTime data;
    public string erabiltzailea;

    public DatosPartida(int id,int puntuazioa, DateTime data,string erabiltzailea)
    {
        this.id = id;
        this.puntuazioa = puntuazioa;
        this.data = data;
        this.erabiltzailea = erabiltzailea;
    }

    override
    public String ToString()
    {
        return "ID: " + id + ",puntuazioa: " + puntuazioa + ",data: " + data + ",erabiltzailea: " + erabiltzailea;
    }
}
