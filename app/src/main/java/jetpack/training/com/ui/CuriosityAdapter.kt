package jetpack.training.com.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import jetpack.training.com.R
import jetpack.training.com.model.Photo
import kotlinx.android.synthetic.main.curiosity_photo.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CuriosityAdapter(private val context: Context, private val listener: PhotoListener) : RecyclerView.Adapter<CuriosityAdapter.PhotoViewHolder>() {

    private var photos = ArrayList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuriosityAdapter.PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.curiosity_photo, parent, false))
    }

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: CuriosityAdapter.PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.cameraName.text = context.getString(R.string.camera, photo.camera.name)
        holder.earthDate.text = context.getString(R.string.data, photo.earthDate)
        holder.rovernName.text = context.getString(R.string.rover, photo.rover.name)
        holder.like.text = context.getString(R.string.like, photo.likeCount.toString())

        Picasso.get()
                .load(photo.imgSrc)
                .placeholder(R.drawable.curiosity)
                .error(R.mipmap.ic_launcher_round)
                .fit().centerCrop()
                .into(holder.img)

        bindEvents(holder, pos = position)
    }

    private fun bindEvents(holder: PhotoViewHolder, pos: Int) {
        holder.img.onClick {
            listener.onPhotoLiked(photos[pos])
        }
    }

    fun setPhotos(photos: List<Photo>) {
        this.photos = photos as ArrayList<Photo>
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.photo
        val cameraName = itemView.tv_camera_name
        val earthDate = itemView.tv_earth_date
        val rovernName = itemView.tv_rover_name
        val like = itemView.tv_like
    }
}