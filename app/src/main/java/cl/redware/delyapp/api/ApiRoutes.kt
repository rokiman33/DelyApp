package cl.redware.delyapp.api

import cl.redware.delyapp.routes.UserRoutes

class ApiRoutes {

    val API_URL = "http://10.0.1.9:3000/api/"
    val retrofit = RetrofitClient()

    fun getUsersRoutes(): UserRoutes{
        return retrofit.getClient(API_URL).create(UserRoutes::class.java)
    }
}