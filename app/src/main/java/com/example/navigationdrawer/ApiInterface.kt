package com.example.navigationdrawer

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("comments")
    fun getProductData() : Call<Myapi>

}