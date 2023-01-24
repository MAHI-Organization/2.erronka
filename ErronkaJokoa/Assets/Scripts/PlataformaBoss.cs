using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlataformaBoss : MonoBehaviour
{
    private BoxCollider2D boxCollider;
    private GameObject jokalaria;

    private bool playerOnPlatform;
    // Start is called before the first frame update
    void Start()
    {
        boxCollider= GetComponent<BoxCollider2D>();
    }

    // Update is called once per frame
    void Update()
    {
        if(playerOnPlatform && Input.GetKeyDown(KeyCode.S)){
            boxCollider.enabled = false;
            StartCoroutine("PlataformaAktibatu");
        }
    }

    IEnumerator PlataformaAktibatu()
    {
        yield return new WaitForSeconds(.5f);
        boxCollider.enabled = true;
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        playerOnPlatform=true;
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        playerOnPlatform=false;
    }
}
