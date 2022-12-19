package cl.redware.delyapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import cl.redware.delyapp.R
import cl.redware.delyapp.models.ResponseHttp
import cl.redware.delyapp.models.Users
import cl.redware.delyapp.provider.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    var imageViewGoToLogin: ImageView? = null
    var editTextName : EditText? = null
    var editTextLastName : EditText? = null
    var editTextEmail : EditText? = null
    var editTextPhone : EditText? = null
    var editTextPassword : EditText? = null
    var editTextConfirmPassword : EditText? = null
    var btnRegister : Button? = null
    var UsersProvider = UsersProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin = findViewById(R.id.imageview_go_to_login)
        editTextName = findViewById(R.id.edittext_name)
        editTextLastName = findViewById(R.id.edittext_lastname)
        editTextEmail = findViewById(R.id.edittext_emailregister)
        editTextPhone = findViewById(R.id.edittext_phone)
        editTextPassword = findViewById(R.id.edittext_passwd)
        editTextConfirmPassword = findViewById(R.id.edittext_confirm_passwd)
        btnRegister = findViewById(R.id.btn_register)
        imageViewGoToLogin?.setOnClickListener { gotologin()}
        btnRegister?.setOnClickListener{Register()}


    }


private fun Register(){

    val name = editTextName?.text.toString()
    val lastname = editTextLastName?.text.toString()
    val email = editTextEmail?.text.toString()
    val phone = editTextPhone?.text.toString()
    val passwd = editTextPassword?.text.toString()
    val confirmpass = editTextConfirmPassword?.text.toString()

    if(isValidateForm(phone = phone, lastname = lastname, name = name, email = email, password = passwd, confirmPassword = confirmpass))
    {
        val users = Users(
            name = name,
            lastname = lastname,
            email = email,
            phone = phone,
            password = passwd
        )

        UsersProvider.register(users)?.enqueue(object: Callback<ResponseHttp>{
            override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {
                Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Se product error ${t.message}", Toast.LENGTH_LONG).show()
            }

        })
    }

}

    fun String.isEmailValid(): Boolean{
        return  !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidateForm(
        name:String,
        lastname:String,
        email: String,
        phone:String,
        password: String,
        confirmPassword:String): Boolean {
        if(name.isBlank())
        {
            Toast.makeText(this,"Debe Ingresar Nombre", Toast.LENGTH_LONG).show()
            return false
        }
        if(lastname.isBlank())
        {
            Toast.makeText(this,"Debe Ingresar Apellido", Toast.LENGTH_LONG).show()
            return false
        }

        if(email.isBlank())
        {
            Toast.makeText(this,"Debe Ingresar Email", Toast.LENGTH_LONG).show()
            return false
        }
        if(phone.isBlank())
        {
            return false
        }
        if(password.isBlank())
        {
            return false
        }
        if(confirmPassword.isBlank())
        {
            return false
        }
        if(!email.isEmailValid())
        {
            return false
        }
        if(password != confirmPassword)
        {
            Toast.makeText(this,"Las Contraseñas No Coinciden!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }



private fun gotologin(){
    var i = Intent(this, MainActivity::class.java)
    startActivity(i)
}


}