package cl.redware.delyapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import cl.redware.delyapp.R
import cl.redware.delyapp.R.*

class MainActivity : AppCompatActivity() {

    var imageviewGoToRegister: ImageView? = null
    var editTextEmail : EditText? = null
    var editTextPassword : EditText? = null
    var btnLogin : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

    imageviewGoToRegister = findViewById(R.id.imageview_go_to_register)
    editTextEmail = findViewById(R.id.edittext_email)
    editTextPassword = findViewById(R.id.edittext_password)
        btnLogin = findViewById(R.id.btn_login)


    imageviewGoToRegister?.setOnClickListener{ goToRegister()}
        btnLogin?.setOnClickListener{ login()}

    }

    private fun login()
    {
      val email = editTextEmail?.text.toString()
      val password = editTextPassword?.text.toString()

        Toast.makeText(this, "El Email es: $email", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "El Password es: $password", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity","El Email es: $email")

        if(isValidateForm(email,password)){
            Toast.makeText(this,"El Formulario es Valido",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"No es Valido",Toast.LENGTH_LONG).show()
        }
    }

    fun String.isEmailValid(): Boolean{
        return  !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidateForm(email: String, password: String): Boolean {
        if(email.isBlank())
        {
            return false
        }
        if(password.isBlank())
        {
            return false
        }
        if(!email.isEmailValid())
        {
            return false
        }
       return true
    }

    private fun goToRegister(){
        val i = Intent(this,RegisterActivity::class.java)
        startActivity(i)
    }

}