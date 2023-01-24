using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class PartidakIkusi : MonoBehaviour
{
    public TextMeshProUGUI partidakTxt;
    // Start is called before the first frame update
    void Start()
    {
        List<DatosPartida> partidak = SaveSystem.CargarDatos();
        Debug.Log("PArtidas totales: " + partidak.Count);
        for (int i = 0; i < partidak.Count; i++)
        {
            partidakTxt.text = partidakTxt.text + " \n" + partidak[i].ToString();
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
