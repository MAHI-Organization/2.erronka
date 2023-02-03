using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;//Edozein script-etik deitu ahal izateko
    [Header("Puntuazioa")]
    public TextMeshProUGUI puntuazioaTxt;
    private int puntuazioa;
    // Start is called before the first frame update
    void Start()
    {
        instance = this;
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void PartidaGorde()
    {
        List<DatosPartida> partidak = SaveSystem.CargarDatos();
        DatosPartida jokatutakoPartida;
        if (partidak != null)
        {
            jokatutakoPartida = new DatosPartida(partidak.Count, puntuazioa, DateTime.Now, "aitzol");
        }
        else
        {
            partidak= new List<DatosPartida>();
            jokatutakoPartida = new DatosPartida(1, puntuazioa, DateTime.Now, "aitzol");
        }
        Debug.Log(jokatutakoPartida.ToString());
        Debug.Log("Partidas totales: " + partidak.Count);
        partidak.Add(jokatutakoPartida);
        SaveSystem.GuardarDatos(partidak);
    }

    public void PuntuazioaGehitu(int puntos)
    {
        puntuazioa += puntos;
        puntuazioaTxt.text = puntuazioa.ToString("0000");
    }

    public void Restart()
    {
        SceneManager.LoadScene("Juego");
    }
}
