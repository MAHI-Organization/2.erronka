using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FireTrap : MonoBehaviour
{
    //Componentes
    private BoxCollider2D fireCollider;
    private Animator animator;

    [Header("Tiempo de fuego")]
    public float fuegoOn = 2f;
    public float fuegoOff = 2f;
    private bool fuegoEncendido = false;
    // Start is called before the first frame update
    void Start()
    {
        fireCollider = GetComponent<BoxCollider2D>();
        animator = GetComponentInParent<Animator>();

        fireCollider.enabled = false;
    }

    // Update is called once per frame
    void Update()
    {
        if (fuegoEncendido)
        {
            return;
        }
        StartCoroutine("EncenderFuego");
    }

    IEnumerator EncenderFuego()
    {
        fuegoEncendido = true;
        fireCollider.enabled = true;
        animator.SetBool("fireOn", true);
        yield return new WaitForSeconds(fuegoOn);
        fireCollider.enabled= false;
        animator.SetBool("fireOn", false);
        yield return new WaitForSeconds(fuegoOn);
        fuegoEncendido=false;
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            if (collision.gameObject.CompareTag("Player"))
            {
                collision.gameObject.GetComponent<SaludJugador>().QuitarVidaJugador();
            }
        }
    }
}
