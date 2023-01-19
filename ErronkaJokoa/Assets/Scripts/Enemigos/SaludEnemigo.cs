using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SaludEnemigo : MonoBehaviour
{
    [Header("Vidas")]
    public int vidasMax;
    private int vidas;

    [Header("Puntos de enemigo")]
    public int puntos;
    // Start is called before the first frame update
    void Start()
    {
        vidas = vidasMax;
    }

    // Update is called once per frame
    void Update()
    {
        Hil();
    }

    private void Hil()
    {
        if(vidas <= 0)
        {
            GameManager.instance.PuntuazioaGehitu(puntos);
            Destroy(gameObject);
        }
    }

    public void QuitarVida()
    {
        vidas--;
    }
}
