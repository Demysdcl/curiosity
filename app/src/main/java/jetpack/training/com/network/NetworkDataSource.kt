package jetpack.training.com.network

import jetpack.training.com.model.Curiosity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkDataSource {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2018-8-1")
    fun fetchCuriosityPhotos(@Query("api_key") key: String): Call<Curiosity>
}