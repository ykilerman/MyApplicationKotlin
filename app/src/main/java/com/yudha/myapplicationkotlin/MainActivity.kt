package com.yudha.myapplicationkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.yudha.myapplicationkotlin.Adapter.MovieAdapter
import com.yudha.myapplicationkotlin.Data.Movie
import com.yudha.myapplicationkotlin.Data.MovieResponse
import com.yudha.myapplicationkotlin.Services.ApiClient
import com.yudha.myapplicationkotlin.Services.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Interceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONException
import org.json.JSONObject
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val TAG : String = MainActivity::class.java.canonicalName
    private lateinit var movies : List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rvMovies.layoutManager = GridLayoutManager(applicationContext, 2)
        val header = getString(R.string.api_key)


        val retrofit= ApiClient.getClient()
        val apiInterface = retrofit.create(ApiInterface::class.java!!)
        getEvent(apiInterface, header)

    }


    fun getEvent(apiInterface: ApiInterface, header : String)  {
        val paramObject = JSONObject()
        try {
            paramObject.put("offset", "0")
            paramObject.put("limit", "100")
            paramObject.put("tipe", "")

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        System.out.println("VALUENYA : "+paramObject.toString())

        val call : Call<MovieResponse> = apiInterface.getListEvent(paramObject.toString(),header)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                System.out.println("VALUENYA ERROR : "+t.toString())
            }

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                if (response!!.body()!!.status.equals("success")){
                    movies= response!!.body()!!.data.list_event!!
                    if (movies.isNotEmpty()){
                        rvMovies.adapter = MovieAdapter(movies,applicationContext)
                        System.out.println("VALUENYA RESPON : "+response!!.body()!!.message)
                    }
                    System.out.println("VALUENYA RESPON : "+response!!.body()!!.message)
                }else{
                    Toast.makeText(applicationContext,response!!.body()!!.message,Toast.LENGTH_SHORT).show()
                    System.out.println("VALUENYA RESPON : "+response!!.body()!!.message)
                }


            }
        })
    }
}