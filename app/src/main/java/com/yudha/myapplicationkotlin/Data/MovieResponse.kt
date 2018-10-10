package com.yudha.myapplicationkotlin.Data

data class MovieResponse(var data : EventList,
                         val status : String,
                         val message:String)
//class MovieResponse {
//
//    lateinit var data : EventList
//    val message: String?=null
//    val status: String?=null
//}