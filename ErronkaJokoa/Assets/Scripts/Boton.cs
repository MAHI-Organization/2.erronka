using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Boton : MonoBehaviour
{
    //Konponenteak
    private Animator animator;
    private BoxCollider2D collider;

    //Collider-a
    private Vector2 colliderNormal = new Vector2(0.28f, 0.226f);
    private Vector2 colliderPisado = new Vector2(0.28f, 0.08f);
    private Vector2 offset = new Vector2(0f, -0.093f);

    //Atea
    public GameObject puerta;
    // Start is called before the first frame update
    void Start()
    {
        animator= GetComponent<Animator>();
        collider= GetComponent<BoxCollider2D>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Player"))
        {
            animator.SetBool("pisado", true);
            collider.offset = offset;
            collider.size = colliderPisado;
            puerta.gameObject.SetActive(false);
        }
    }
}
