using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SaludEnemigo : MonoBehaviour
{
    [Header("Vidas")]
    public float vidasMax;
    public float vidas;

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
        if(gameObject.CompareTag("Boss") && vidas / vidasMax <= 0.1)
        {
            vidas = vidasMax;
        }else if(vidas <= 0)
        {
            GameManager.instance.PuntuazioaGehitu(puntos);
            Destroy(gameObject);
        }
    }


    public void QuitarVida()
    {
        vidas--;
        if (gameObject.CompareTag("Boss"))
        {
            GameManager.instance.PuntuazioaGehitu(puntos);
        }
    }
}
