package jetpack.training.com.di

import jetpack.training.com.di.NetworkProperties.BASE_URL
import jetpack.training.com.network.NetworkDataSource
import org.koin.dsl.module.applicationContext
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkProperties {
    const val BASE_URL = "BASE_URL"
}

fun createBaseURL() = "https://api.nasa.gov"

fun createConverterFactory(): Converter.Factory {
    return GsonConverterFactory.create()
}

inline fun <reified T> createWebService(baseUrl: String, factory: Converter.Factory): T {
    val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
    return retrofit.create(T::class.java)
}

val networkModule = applicationContext {
    bean(BASE_URL, definition = { createBaseURL() })
    bean { createConverterFactory() }
    bean { createWebService<NetworkDataSource>(get(BASE_URL), get()) }
}