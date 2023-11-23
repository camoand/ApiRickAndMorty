package com.example.pruebatecnicabolsiyo.core.model

sealed class Routes(val routes: String){
    object Pantalla1:Routes("pantalla1")
    object Pantalla2:Routes("pantalla2/{id}"){
        fun createRoute(id:Int) = "pantalla2/$id"
    }
}
