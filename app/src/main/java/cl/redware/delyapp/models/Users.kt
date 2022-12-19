package cl.redware.delyapp.models

import com.google.gson.annotations.SerializedName

class Users(
   @SerializedName("id") val id: String? = null,
   @SerializedName("name") val name: String,
   @SerializedName("lastname") val lastname: String,
   @SerializedName("email") val email: String,
   @SerializedName("phone") val phone: String,
   @SerializedName("password") val password: String,
   @SerializedName("image") val image: String? = null,
   @SerializedName("session_token") val session_token: String? = null,
   @SerializedName("is_available") val is_available: Boolean? = null,
) {

    override fun toString(): String {
        return "Users(id='$id', name='$name', lastname='$lastname', email='$email', phone='$phone', password='$password', image='$image', session_token='$session_token', is_available=$is_available)"
    }
}