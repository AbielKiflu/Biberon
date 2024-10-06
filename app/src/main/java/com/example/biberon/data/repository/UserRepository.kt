package com.example.biberon.data.repository

import com.example.biberon.data.model.LoggedInUser
import com.example.biberon.data.remote.service.RetrofitClient
import retrofit2.Call

class UserRepository {
    fun getUser(userId: Int, callback: (Result<LoggedInUser>) -> Unit) {
        RetrofitClient.apiService.getUser(userId).enqueue(object : retrofit2.Callback<LoggedInUser> {
            override fun onResponse(call: Call<LoggedInUser>, response: retrofit2.Response<LoggedInUser>) {
                if (response.isSuccessful) {
                    response.body()?.let { user ->
                        callback(Result.success(user))
                    } ?: callback(Result.failure(Exception("User not found")))
                } else {
                    callback(Result.failure(Exception("Error: ${response.code()}")))
                }
            }

            override fun onFailure(call: Call<LoggedInUser>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }
}
