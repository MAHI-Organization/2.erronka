using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlantaEnemiga : MonoBehaviour
{
    //Konponenteak
    private Animator animator;

    [Header("Disparo")]
    public GameObject bala;
    public Transform disparoPos;
    public float balaSpeed;
    public float cooldownTime = 2f;
    private bool canShoot = true;
    // Start is called before the first frame update
    void Start()
    {
        animator= GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        if (!canShoot)//Coroutine-a martxan dagoen bitartean ez hasteko
        {
            return;
        }
        StartCoroutine("DisparoPlanta");
    }

    private void DispararBala()//Disparatzeko animazioan dago animation event bezala
    {
        Instantiate(bala, disparoPos.position,disparoPos.rotation).GetComponent<Rigidbody2D>().velocity = -transform.right * balaSpeed;
    }


    IEnumerator DisparoPlanta()
    {
        canShoot= false;
        animator.SetTrigger("disparar");//Tiro egiten da 
        yield return new WaitForSeconds(cooldownTime);//X segundu itxaroten dira berriro tiro egin ahal izan arte
        canShoot= true;
    }
}
