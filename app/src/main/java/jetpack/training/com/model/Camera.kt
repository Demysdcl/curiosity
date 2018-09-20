package jetpack.training.com.model

import com.google.gson.annotations.SerializedName

class Camera(val id: Int,
             val name: String,
             @SerializedName("full_name") val fullName: String)