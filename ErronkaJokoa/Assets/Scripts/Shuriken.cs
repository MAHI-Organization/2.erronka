using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Shuriken : MonoBehaviour
{
    private Rigidbody2D rbShuriken;

    //Velocidad shuriken
    private float velShuriken = 5f;

    //Alcance shuriken
    private float alcanceMax = 0.5f;
    private float alcance = 0f;
    // Start is called before the first frame update
    void Start()
    {
        rbShuriken = GetComponent<Rigidbody2D>();
        rbShuriken.velocity = transform.right * velShuriken;
    }

    // Update is called once per frame
    void Update()
    {
        AlcanceShuriken();
    }

    private void AlcanceShuriken()
    {
        if(alcance <= alcanceMax)
        {
            alcance += Time.deltaTime;
        }else if(alcance > alcanceMax)
        {
            Destroy(gameObject);
        }
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.CompareTag("Enemigo"))
        {
            other.GetComponent<SaludEnemigo>().QuitarVida();
            Destroy(gameObject);
        }
    }
}
