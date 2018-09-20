package jetpack.training.com.model

import com.google.gson.annotations.SerializedName

class Photo(val sol: Int,
            val camera: Camera,
            @SerializedName("img_src") val imgSrc: String,
            @SerializedName("earth_date") val earthDate: String,
            val rover: Rover,
            var likeCount: Int
)