package com.yudha.myapplicationkotlin.Services

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

class ApiClient {
    companion object {
        fun getClient() : Retrofit {
            val BASE_URL = "http://172.168.100.58:8211/lupirka/api/v1/"
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val original = chain.request()

                    // Request customization: add request headers
                    val requestBuilder = original.newBuilder()
                            .header("Authorization", "auth-value") // <-- this is the important line

                    val request = requestBuilder.build()
                    return chain.proceed(request)
                }
            })

            val client = httpClient.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

            return retrofit
        }
    }
}