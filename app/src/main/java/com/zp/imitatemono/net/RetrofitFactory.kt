package com.zp.imitatemono.net

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.google.gson.GsonBuilder




/**
 * Created by 安眠 on 2017/12/30.
 */
class RetrofitFactory private constructor() {

    private val BASE_URL = "http://mmmono.com/"
    private val TIMEOUT: Long = 20


    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    private val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()

    private val retrofitService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create())
            // 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(RetrofitService::class.java)

    fun builder(): RetrofitService {
        return retrofitService
    }

    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

}