package cl.redware.delyapp.provider

import cl.redware.delyapp.api.ApiRoutes
import cl.redware.delyapp.models.ResponseHttp
import cl.redware.delyapp.models.Users
import cl.redware.delyapp.routes.UserRoutes
import retrofit2.Call

class UsersProvider {

    private var userRoutes: UserRoutes? = null

    init {
        val api = ApiRoutes()
        userRoutes = api.getUsersRoutes()
    }

    fun register(users: Users): Call<ResponseHttp>? {
        return  userRoutes?.register(users)
    }



}