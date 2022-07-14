package com.semanureserler.retrofitexample

import com.semanureserler.retrofitexample.Constant.END_POINT_GET
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET(END_POINT_GET)
    suspend fun getAllPosts():Response<List<PostItem>>
}