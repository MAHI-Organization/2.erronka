using Mono.Data.Sqlite;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Net.Sockets;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading;
using UnityEngine;

public class TcpBezero : MonoBehaviour
{

    public static TcpBezero instance;
    private TcpClient socketConnection;
    private Thread clientReceiveThread;
    private void Awake()
    {
        instance = this;
    }
    private void Start()
    {
        ZerbitzariraKonektatu();
    }

    private void Update()
    {
        
    }
    private void ZerbitzariraKonektatu()
    {
        try
        {
            clientReceiveThread = new Thread(new ThreadStart(Konektatu));
            clientReceiveThread.IsBackground = true;
            clientReceiveThread.Start();
        }
        catch (Exception e)
        {
            Debug.Log("On client connect exception " + e);
        }
    }

    private List<Partida> SQLPartidakKargatu()
    {
        List<Partida> partidak = new List<Partida>();
        string connection = "URI=file:" + Application.dataPath + "/jokoadb.db";
        IDbConnection dbcon = new SqliteConnection(connection);
        dbcon.Open();

        IDbCommand cmnd_read = dbcon.CreateCommand();
        IDataReader reader; string query = "SELECT * FROM partida";
        cmnd_read.CommandText = query;
        reader = cmnd_read.ExecuteReader(); while (reader.Read())
        {
            Partida partida = new Partida(Int32.Parse(reader[0].ToString()), reader[1].ToString(), reader[2].ToString(), Int32.Parse(reader[3].ToString()));
            partidak.Add(partida);
        }
        dbcon.Close();
        return partidak;
    }

    private void SQLPartidakEzabatu()
    {
        string connection = "URI=file:" + Application.dataPath + "/jokoadb.db";
        IDbConnection dbcon = new SqliteConnection(connection);
        dbcon.Open();

        IDbCommand cmnd = dbcon.CreateCommand();
        cmnd.CommandText = "DELETE FROM partida";
        cmnd.ExecuteNonQuery();

        dbcon.Close();
    }

    private void Konektatu()
    {
        try
        {
            socketConnection = new TcpClient("192.168.65.95", 8052);//Zerbitzariko portura konektatu
        }
        catch (SocketException socketException)
        {
            Debug.Log("Socket exception: " + socketException);
        }
    }

    public void DatuakBidali()
    {
        if (socketConnection == null)
        {
            Debug.Log("Ez dago konexiorik");
            return;
        }else if(socketConnection != null)
        {
            try
            {
                List<Partida> gordetakoPartidak = SQLPartidakKargatu();
                //Stream hartu datuak bidaltzeko. 			
                NetworkStream stream = socketConnection.GetStream();
                if (stream.CanWrite)
                {
                    for (int i = 0; i < gordetakoPartidak.Count; i++)
                    {
                        string bidaltzekoPartida = gordetakoPartidak[i].id + "," + gordetakoPartidak[i].erabiltzailea + ", " + gordetakoPartidak[i].data + ", " + gordetakoPartidak[i].puntuazioa + "\n";
                        //Mezua byte array baten bihurtu                
                        byte[] mezuaArray = Encoding.ASCII.GetBytes(bidaltzekoPartida);
                        // Byte array-a zerbitzarira bidali              
                        stream.Write(mezuaArray, 0, mezuaArray.Length);
                        Debug.Log("Partida bidali da");
                    }
                    SQLPartidakEzabatu();
                }
            }
            catch (SocketException socketException)
            {
                Debug.Log("Socket exception: " + socketException);
            }
        }
    }
}
