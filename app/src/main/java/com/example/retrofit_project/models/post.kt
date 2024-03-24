package com.example.retrofit_project.models

import java.io.Serializable

data class post(
    val userId:Int,
    val id:Int,
    val title:String,
    val body:String):Serializable

