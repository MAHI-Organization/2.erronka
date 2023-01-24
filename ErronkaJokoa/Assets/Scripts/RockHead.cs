using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;

public class RockHead : MonoBehaviour
{
    private Rigidbody2D rbRock;
    private float speed = 0.75f;
    // Start is called before the first frame update
    void Start()
    {
        rbRock= GetComponent<Rigidbody2D>();
        rbRock.velocity = transform.right * speed;
    }

    // Update is called once per frame
    void Update()
    {
        
    }

}
