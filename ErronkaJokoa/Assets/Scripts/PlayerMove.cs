using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMove : MonoBehaviour
{
    //Konponenteak
    Rigidbody2D rb2D;
    Animator animator;
    [Header("Mugimendua")]
    //Mugimendua
    public float runSpeed = 2;
    public float jumpSpeed = 3;
    public int numSalto = 0;
    private float horizontalInput;
    public Joystick joystick;
    //Rotazioa
    private int rot = 1;//0 --> ezkerra, 1--> eskuma

    [Header("Disparo")]
    //Disparo
    public GameObject projectil;
    public Transform puntoDeDisparo;
    public float velDisparo;
    private float proximoDisparo;
    // Start is called before the first frame update
    void Start()
    {
        rb2D = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
    }

    private void Update()
    {
        JokalariarenRotazioa();

        horizontalInput = Input.GetAxis("Horizontal");

        Salto();

        Disparo();
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        if (horizontalInput != 0)     
        {
            rb2D.AddForce(new Vector2(runSpeed * horizontalInput, rb2D.velocity.y) - rb2D.velocity,ForceMode2D.Impulse);
            animator.SetBool("isRunning", true);
        }else if(joystick.Horizontal != 0)
        {
            rb2D.AddForce(new Vector2(runSpeed * joystick.Horizontal, rb2D.velocity.y) - rb2D.velocity, ForceMode2D.Impulse);
            animator.SetBool("isRunning", true);
        }
        else
        {
            rb2D.velocity = new Vector2(0, rb2D.velocity.y);
            animator.SetBool("isRunning", false);
        }
    }

    private void Salto()
    {
        if (CheckGround.isGrounded)//Lurrean badago salto kantitatea 0n jarri
        {
            animator.SetBool("isJumping", false);
            numSalto = 0;
        }else if (!CheckGround.isGrounded)
        {
            animator.SetBool("isJumping", true);
        }
        if ((Input.GetKeyDown(KeyCode.Space) && CheckGround.isGrounded) || (Input.GetKeyDown(KeyCode.Space) && numSalto < 2))//Lurrean badago edo 2 aldiz baino gutxiagotan egin badu salto, salto egin dezake
        {
            rb2D.AddForce(new Vector2(rb2D.velocity.x, jumpSpeed), ForceMode2D.Impulse);
            numSalto++;
        }
    }

    private void JokalariarenRotazioa()
    {
        if(rot == 1 && (horizontalInput < 0 || joystick.Horizontal < 0))//Eskumara begira baldin badago eta ezkerrera mugitzen bada jokalaria ezkerrera rotatzen da
        {
            transform.Rotate(0, 180, 0);
            rot = 0;
        }else if(rot == 0 && (horizontalInput > 0 || joystick.Horizontal > 0))//Ezkerrera begira baldin badago eta eskumara mugitzen bada jokalaria eskumara rotatzen da
        {
            transform.Rotate(0, 180, 0);
            rot = 1;
        }
    }

    private void Disparo()
    {
        if((Input.GetMouseButtonDown(1) || Input.GetMouseButton(1)) && proximoDisparo <= Time.time){
            proximoDisparo = Time.time + 1f / velDisparo;
            Instantiate(projectil, puntoDeDisparo.position, transform.rotation);
        }
    }

    public void BotonDisparo()
    {
        if (proximoDisparo <= Time.time)
        {
            proximoDisparo = Time.time + 1f / velDisparo;
            Instantiate(projectil, puntoDeDisparo.position, transform.rotation);
        }
    }

    public void BotonSalto()
    {
        if (CheckGround.isGrounded)//Lurrean badago salto kantitatea 0n jarri
        {
            animator.SetBool("isJumping", false);
            numSalto = 0;
        }
        else if (!CheckGround.isGrounded)
        {
            animator.SetBool("isJumping", true);
        }
        if  (CheckGround.isGrounded || numSalto < 2)//Lurrean badago edo 2 aldiz baino gutxiagotan egin badu salto, salto egin dezake
        {
            rb2D.AddForce(new Vector2(rb2D.velocity.x, jumpSpeed), ForceMode2D.Impulse);
            numSalto++;
        }
    }

}
