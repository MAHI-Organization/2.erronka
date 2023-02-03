using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MahiBoss : MonoBehaviour
{
    private Rigidbody2D rbMahi;

    [Header("Bizitza")]
    public Image bizitzaUI;
    private SaludEnemigo saludEnemigo;

    [Header("Mugimendua")]
    public float yTime = 2f;
    public float pausaTime = 3f;
    private bool mugitzen = false;
    private bool canAttack = true;

    [Header("Disparo")]
    //Disparo
    public GameObject projectil;
    public Transform puntoDeDisparo;
    public float velDisparo;
    public float balaSpeed;
    private float proximoDisparo;
    // Start is called before the first frame update
    void Start()
    {
        rbMahi= GetComponent<Rigidbody2D>();
        saludEnemigo = GetComponent<SaludEnemigo>();
    }

    // Update is called once per frame
    void Update()
    {
        BarraBizitza();
        Disparo();
        if (mugitzen)//Mugitzen ari den bitartean Coroutine-a behin eta berriz ez hasteko
        {
            return;
        }
        StartCoroutine("Mugimendua");
    }

    private void BarraBizitza()
    {
        bizitzaUI.fillAmount = saludEnemigo.vidas / saludEnemigo.vidasMax;
        //Debug.Log("Vidas mahi: " + saludEnemigo.vidas / saludEnemigo.vidasMax);
    }

    private void Disparo()
    {
        if (proximoDisparo <= Time.time)
        {
            proximoDisparo = Time.time + 1f / velDisparo;
            Instantiate(projectil, puntoDeDisparo.position, transform.rotation).GetComponent<Rigidbody2D>().velocity = -transform.right * balaSpeed;
        }
    }

    IEnumerator Mugimendua()
    {
        mugitzen = true;
        rbMahi.velocity = new Vector2(0, 1);//Ezkerrera mugitu
        yield return new WaitForSeconds(yTime);
        rbMahi.velocity = Vector2.zero;//Geldi egon
        yield return new WaitForSeconds(pausaTime);
        rbMahi.velocity = new Vector2(0, -1);//Eskubira mugitu
        yield return new WaitForSeconds(yTime);
        rbMahi.velocity = Vector2.zero;//Geldi egon
        yield return new WaitForSeconds(pausaTime);
        mugitzen = false;
    }
}
