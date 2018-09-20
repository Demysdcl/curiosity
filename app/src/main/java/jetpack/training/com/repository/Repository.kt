package jetpack.training.com.repository

import android.arch.lifecycle.LiveData
import jetpack.training.com.model.Curiosity

interface Repository {

    fun getCuriosityPhotos(): LiveData<Curiosity>
}