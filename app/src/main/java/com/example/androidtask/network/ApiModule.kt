package com.example.androidtask.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {




    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        var client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)
       // try {

            //client.cache(cache)

      //  client  .addInterceptor(object  LoggingInterceptor())
        client.networkInterceptors().add(StethoInterceptor())
           // client.connectTimeout(10, TimeUnit.SECONDS)

     // client.addNetworkInterceptor(interceptor) // same for .addInterceptor(...)
        client  .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
        client   .writeTimeout(30, TimeUnit.SECONDS)
        client   .readTimeout(30, TimeUnit.SECONDS)
            return client.build()

      //  }catch ( ex:Exception){
      //       return client.callTimeout(23,TimeUnit.DAYS)
      //  }


    }


    @Singleton
    @Provides
    fun provideTBIAPI(  client: OkHttpClient): ApiService {
       // try {
            return Retrofit.Builder()
             // .addConverterFactory(xmlFactory)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://yogahez.mountasher.online/")
                .client(client)
                .build()
                .create(ApiService::class.java)

  }


}