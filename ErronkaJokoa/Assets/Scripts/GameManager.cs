using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

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

    public void PuntuazioaGehitu(int puntos)
    {
        puntuazioa += puntos;
        puntuazioaTxt.text = puntuazioa.ToString("0000");
    }
}
