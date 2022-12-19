package cl.redware.delyapp.routes

import cl.redware.delyapp.models.ResponseHttp
import cl.redware.delyapp.models.Users
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call


interface UserRoutes {

    @POST("users/create")
    fun register(@Body users: Users) : Call<ResponseHttp>


}