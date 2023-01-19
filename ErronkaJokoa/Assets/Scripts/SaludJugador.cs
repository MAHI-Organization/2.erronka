using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SaludJugador : MonoBehaviour
{
    [Header("Vidas")]
    private int vidas = 3;
    public Image[] vidasUI;
    // Start is called before the first frame update
    void Start()
    {
        
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
            gameObject.SetActive(false);
        }
    }

    public void QuitarVidaJugador()
    {
        vidas--;
        if(vidas >= 0)
        {
            vidasUI[vidas].color = Color.black;
        }
    }
}
