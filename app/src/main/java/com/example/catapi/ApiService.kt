package com.example.catapi

import com.example.catapi.data.Breeds
import com.example.catapi.data.Images
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("images/search")
    fun getImage(
    ):Observable<List<Images>>

    @GET("breeds")
    fun getbreeds(
    ):Observable<List<Breeds>>

    companion object{
        fun create():ApiService{
        val BASE_URL = "https://api.thecatapi.com/v1/"

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(ApiService::class.java)

}}}