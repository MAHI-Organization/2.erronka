using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bunny : MonoBehaviour
{
    private Rigidbody2D rbBunny;
    private Animator animator;

    private GameObject jokalaria;
    //Mugimendua bigilatzen
    [Header("Mugimendua")]
    private float distancia;
    [SerializeField]private float distanciaAtaque;
    private Vector2 movDir;
    [SerializeField]private float mugAbiadura;

    //Cooldown
    private bool canAttack = true;
    // Start is called before the first frame update
    void Start()
    {
        rbBunny = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();

        jokalaria = GameObject.FindGameObjectWithTag("Player");//Jokalaria bilatu
    }

    // Update is called once per frame
    void Update()
    {
        Ataque();

        //Gravedad();
    }

    private void Gravedad()
    {
        if(rbBunny.velocity.y < 0)
        {
            rbBunny.velocity = new Vector2(rbBunny.velocity.x, -3f);
        }
    }

    private void Ataque()
    {
        if (canAttack && jokalaria.transform.position.y < transform.position.y + 0.5f && Vector2.Distance(transform.position, jokalaria.transform.position) <= distanciaAtaque)
        {
            animator.SetBool("running", true);
            movDir = jokalaria.transform.position - transform.position;
            movDir.Normalize();
            movDir.y = 0;
            rbBunny.AddForce((movDir * mugAbiadura)-rbBunny.velocity, ForceMode2D.Impulse);
        }
        else
        {
            animator.SetBool("running", false);
            rbBunny.velocity = Vector2.zero;
        }
    }

    IEnumerator CooldownAtaque()
    {
        canAttack = false;
        yield return new WaitForSeconds(3f);
        canAttack = true;
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Player"))
        {
            collision.gameObject.GetComponent<SaludJugador>().QuitarVidaJugador();
            StartCoroutine("CooldownAtaque");
        }
    }

}
