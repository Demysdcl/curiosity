package jetpack.training.com.model

import com.google.gson.annotations.SerializedName

class Rover(val id: Int,
            val name: String,
            @SerializedName("landing_date") val landingDate: String,
            @SerializedName("launch_date") val launchDate: String,
            @SerializedName("total_photos") val totalPhotos: Int
)