using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bat : MonoBehaviour
{
    private Rigidbody2D rbBat;

    [Header("Mugimendua")]
    public float xTime = 2f;
    public float pausaTime = 3f;
    private bool mugitzen = false;
    private bool canAttack = true;
    // Start is called before the first frame update
    void Start()
    {
        rbBat = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {
        if (mugitzen)//Mugitzen ari den bitartean Coroutine-a behin eta berriz ez hasteko
        {
            return;
        }
        StartCoroutine("Mugimendua");
    }

    IEnumerator Mugimendua()
    {
        mugitzen= true;
        rbBat.velocity = new Vector2(-1,0);//Ezkerrera mugitu
        yield return new WaitForSeconds(xTime);
        rbBat.velocity = Vector2.zero;//Geldi egon
        yield return new WaitForSeconds(pausaTime);
        rbBat.velocity = new Vector2(1, 0);//Eskubira mugitu
        yield return new WaitForSeconds(xTime);
        rbBat.velocity = Vector2.zero;//Geldi egon
        yield return new WaitForSeconds(pausaTime);
        mugitzen = false;
    }

    IEnumerator CooldownAtaque()
    {
        canAttack = false;
        yield return new WaitForSeconds(3f);
        canAttack = true;
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (canAttack && collision.CompareTag("Player"))
        {
            collision.gameObject.GetComponent<SaludJugador>().QuitarVidaJugador();
            StartCoroutine("CooldownAtaque");
        }
    }
}
