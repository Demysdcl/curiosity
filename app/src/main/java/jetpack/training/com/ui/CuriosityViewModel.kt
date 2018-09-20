package jetpack.training.com.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import jetpack.training.com.model.Photo
import jetpack.training.com.repository.Repository

class CuriosityViewModel(private val repository: Repository) : ViewModel() {


    val picture = MutableLiveData<Photo>()

    var totalClick: MutableLiveData<Int> = MutableLiveData()

    fun getPhotos() = repository.getCuriosityPhotos()

    fun onPicLiked(photo: Photo) {
        photo.likeCount += 1
        picture.postValue(photo)
    }

    fun incrementTotalClick() {
        val currentValue = totalClick.value ?: 0
        totalClick.postValue(currentValue + 1)
    }
}