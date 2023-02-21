using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Npgsql;
using TMPro;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Login : MonoBehaviour
{
    public TextMeshProUGUI izenaHutsik;
    public TMP_InputField erabiltzaileaInput;
    private string erabiltzailea;
    // Start is called before the first frame update
    void Start()
    {
        izenaHutsik.gameObject.SetActive(false);

    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void Hasi()
    {
        if (erabiltzaileaInput.text.Length != 0)
        {
            erabiltzailea = erabiltzaileaInput.text;
            PlayerPrefs.SetString("Erabiltzailea", erabiltzailea);
            Debug.Log(erabiltzailea);
            SceneManager.LoadScene("Juego");
        }
        else
        {
            izenaHutsik.gameObject.SetActive(true);
            Debug.Log("Erabiltzailearen izena sartu behar duzu");
        }

    }

    public void Itxi()
    {
        Application.Quit();
    }
}
