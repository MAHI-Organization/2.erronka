using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SaludJugador : MonoBehaviour
{
    [Header("Vidas")]
    private int vidas = 3;
    public Image[] vidasUI;

    [Header("Game Over")]
    public GameObject menuGameOver;
    // Start is called before the first frame update
    void Start()
    {
        //SaveSystem.BorrarDatos();
        menuGameOver.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        Hil();
    }

    private void Hil()
    {
        if(vidas <= 0 || transform.position.y < -9)
        {
            GameManager.instance.PartidaGorde();
            TcpBezero.instance.DatuakBidali();
            menuGameOver.SetActive(true);
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
