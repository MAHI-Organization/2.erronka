using System.Collections;
using System.Collections.Generic;
using System.Reflection;
using UnityEngine;

public class Projectile : MonoBehaviour
{
    public GameObject projectile;
    
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(new Vector3(0, -5 * Time.deltaTime, 0));
        
    }
  

      
    }


