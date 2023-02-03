using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using Unity.VisualScripting;
using UnityEngine;

public static class SaveSystem
{
    /*Partidei buruzko datuak gordetzeko metodoa*/
    public static void GuardarDatos(List<DatosPartida> partidasJugadas)
    {
        BinaryFormatter formatter = new BinaryFormatter();
        string path = Application.persistentDataPath + "partidas.json";
        FileStream stream = new FileStream(path, FileMode.Create);

        List<DatosPartida> partidas = partidasJugadas;

        formatter.Serialize(stream, partidas);
        stream.Close();
    }
    /*Partida guztiak ezabatzeko metodoa*/
    public static void BorrarDatos()
    {
        BinaryFormatter formatter = new BinaryFormatter();
        string path = Application.persistentDataPath + "partidas.json";
        FileStream stream = new FileStream(path, FileMode.Create);

        List<DatosPartida> partidas = new List<DatosPartida>();

        formatter.Serialize(stream, partidas);
        stream.Close();
    }
    /*Partidei buruzko informazioa kargatzeko metodoa*/
    public static List<DatosPartida> CargarDatos()
    {
        string path = Application.persistentDataPath + "partidas.json";
        if(File.Exists(path))
        {
            BinaryFormatter formatter = new BinaryFormatter();
            FileStream stream = new FileStream(path, FileMode.Open);

            List<DatosPartida> partidas = formatter.Deserialize(stream) as List<DatosPartida>;
            stream.Close();
            return partidas;
        }
        else
        {
            Debug.LogWarning("Ez dago partidarik");
            return null;
        }
    }
}
