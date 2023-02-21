using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BalaPlanta : MonoBehaviour
{
    private float alcanceMax = 3f;
    private float currentAlcance = 0f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        DestruirBala();
    }

    private void DestruirBala()
    {
        if(currentAlcance <= alcanceMax)
        {
            currentAlcance += Time.deltaTime;
        }
        else
        {
            Destroy(gameObject);
        }
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            collision.gameObject.GetComponent<SaludJugador>().QuitarVidaJugador();
            Destroy(gameObject);
        }
    }
}
