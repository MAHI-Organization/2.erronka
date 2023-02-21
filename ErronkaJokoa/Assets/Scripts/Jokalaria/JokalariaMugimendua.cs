using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class JokalariaMugimendua : MonoBehaviour
{
    //Komponenteak
    private Rigidbody2D rb;

    //Mugimendua
    [Header("Mugimendua")]
    [SerializeField] private float mugAbiadura;
    private float horizontalInput;
    private Vector2 mug;

    //Salto
    [Header("Salto")]
    [SerializeField] private float saltoAltuera;
    [SerializeField] private float saltoDenbora;
    private bool saltoEgiten = false;
    private float saltoContador;

    //Lurra ikutzen ari dela
    [Header("Lurrean Check")]
    private bool lurreanDago;
    [SerializeField] private Transform lurraPos;
    [SerializeField] private float radius;
    [SerializeField] private LayerMask lurraMask;

    //Gravedad
    private float fuerzaGravedad = 9.81f;

    //Doble salto
    private int saltoKopurua = 0;
    [SerializeField] private int saltoKopuruaMax = 2;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {
        lurreanDago = Physics2D.OverlapCircle(lurraPos.position, radius, lurraMask);

        if (lurreanDago)
        {
            saltoKopurua = 0;
        }

        if (Input.GetKeyDown(KeyCode.Space))
        {
            if (lurreanDago || saltoKopurua < saltoKopuruaMax)
            {
                saltoEgiten = true;
                saltoContador = saltoDenbora;
                rb.velocity = Vector2.up * saltoAltuera;

                if (!lurreanDago)
                {
                    saltoKopurua++;
                }
            }
        }

        if (Input.GetKey(KeyCode.Space) && saltoEgiten && saltoContador > 0)
        {
            rb.velocity = Vector2.up * saltoAltuera;
            saltoContador -= Time.deltaTime;
        }
        else
        {
            saltoEgiten = false;
        }

        if (Input.GetKeyUp(KeyCode.Space))
        {
            saltoEgiten = false;
        }
    }

    private void FixedUpdate()
    {
        Mugimendua();
    }

    private void Mugimendua()
    {
        horizontalInput = Input.GetAxis("Horizontal");
        mug = new Vector2(horizontalInput * mugAbiadura, rb.velocity.y);
        rb.velocity = mug;
    }

    
}
