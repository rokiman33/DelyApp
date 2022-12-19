package cl.redware.delyapp.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class ResponseHttp (
   @SerializedName("message") val message: String,
   @SerializedName("success") val success: Boolean,
   @SerializedName("data") val data: JsonObject,
   @SerializedName("error") val errpr: String,
        ) {
    override fun toString(): String {
        return "ResponseHttp(message='$message', success=$success, data=$data, errpr='$errpr')"
    }
}