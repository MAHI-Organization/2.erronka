using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PuertaBoss : MonoBehaviour
{
    public GameObject bossUI;
    public GameObject mahiBoss;
    // Start is called before the first frame update
    void Start()
    {
        mahiBoss.SetActive(false);
        bossUI.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.CompareTag("Player"))
        {
            bossUI.SetActive(true);
            mahiBoss.SetActive(true);
        }
    }
}
