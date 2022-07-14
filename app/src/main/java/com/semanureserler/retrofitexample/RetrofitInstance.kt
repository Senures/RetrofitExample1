package com.semanureserler.retrofitexample

import com.google.gson.Gson
import com.semanureserler.retrofitexample.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit:PostApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PostApi::class.java)
    }
}