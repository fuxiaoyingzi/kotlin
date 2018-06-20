package com.shadow.base.data.net

import com.kotlin.base.utils.AppPrefsUtils
import com.shadow.base.common.BaseConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/3/003
 */
class RetrofitFactory private constructor() {
    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val intercept: Interceptor //头部拦截器

    init {
        intercept = Interceptor { chain ->
            val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "utf-8")
                    .addHeader("token", AppPrefsUtils.getString(BaseConstants.KEY_SP_TOKEN))
                    .build()
            chain.proceed(request)
        }
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstants.SERVICE_UTL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(initLoginIntercept())
                .addInterceptor(intercept)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    private fun initLoginIntercept(): HttpLoggingInterceptor {
        val intercept = HttpLoggingInterceptor()
        intercept.level = HttpLoggingInterceptor.Level.BODY
        return intercept
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}