package com.example.androidtask.network
import com.example.androidtask.business.models.LoginModel
import com.example.androidtask.business.models.RequestModel
import kotlinx.coroutines.Deferred
import retrofit2.http.*


interface ApiService {


  @Headers("Content-Type: application/json")
    @POST("api/login")
    fun LoginApI(
      @Body requestModel: RequestModel
        ): Deferred<LoginModel>



}