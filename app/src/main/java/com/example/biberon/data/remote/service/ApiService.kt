package com.example.biberon.data.remote.service
import com.example.biberon.data.model.LoggedInUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("users/{id}")
    fun getUser(@Path("id") userId: Int): Call<LoggedInUser>
}
