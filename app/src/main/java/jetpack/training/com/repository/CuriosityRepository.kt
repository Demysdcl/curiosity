package jetpack.training.com.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import jetpack.training.com.model.Curiosity
import jetpack.training.com.model.CuriosityError
import jetpack.training.com.network.NetworkDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuriosityRepository(private val dataSource: NetworkDataSource) : Repository {

    companion object {
        const val API_KEY = "U3rV7BEbv1CikdMpuHCESh0XqWMeYn7l96sLUZ1k"
    }

    private val curiosityLiveData = MutableLiveData<Curiosity>()

    override fun getCuriosityPhotos(): LiveData<Curiosity> {
        dataSource.fetchCuriosityPhotos(API_KEY).enqueue(object : Callback<Curiosity> {

            override fun onResponse(call: Call<Curiosity>, response: Response<Curiosity>?) {
                val curiosity = response?.body()
                if (response != null && response.isSuccessful && curiosity != null) {
                    curiosityLiveData.postValue(curiosity)
                } else {
                    curiosityLiveData.postValue(Curiosity())
                }
            }

            override fun onFailure(call: Call<Curiosity>, t: Throwable) {
                curiosityLiveData.postValue(CuriosityError("error loading photos..."))
            }

        })

        return curiosityLiveData
    }
}