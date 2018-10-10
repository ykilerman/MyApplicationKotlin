package com.yudha.myapplicationkotlin.Services

import com.yudha.myapplicationkotlin.Data.Movie
import com.yudha.myapplicationkotlin.Data.MovieResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("ada.php")
    fun getListEvent(@Body body: String, @Header("Authorization") authorization: String): Call<MovieResponse>




}