package jetpack.training.com.ui

import jetpack.training.com.model.Photo

interface PhotoListener {
    fun onPhotoLiked(photo: Photo)
}