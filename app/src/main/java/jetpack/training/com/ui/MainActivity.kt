package jetpack.training.com.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import jetpack.training.com.R
import jetpack.training.com.model.Curiosity
import jetpack.training.com.model.CuriosityError
import jetpack.training.com.model.Photo
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity(), PhotoListener {

    private val viewModel: CuriosityViewModel by viewModel()

    private lateinit var adapter: CuriosityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        bindOutputs()
    }

    private fun bindOutputs() {
        viewModel.getPhotos().observe(this, Observer<Curiosity> {
            when (it) {
                is Curiosity -> {
                    adapter.setPhotos(it.photos)
                    adapter.notifyDataSetChanged()
                }

                is CuriosityError -> {
                    toast(it.msg)
                }
            }
        })

        viewModel.picture.observe(this, Observer<Photo> {
            adapter.notifyDataSetChanged()
        })

        viewModel.totalClick.observe(this, Observer<Int> { it ->
            it?.let {
                tv_total_click.text = getString(R.string.total_click, it.toString())
            }
        })
    }

    private fun setupRecycler() {
        adapter = CuriosityAdapter(applicationContext, this)
        val layoutManager = LinearLayoutManager(this)
        rv_photos.layoutManager = layoutManager
        rv_photos.adapter = adapter
    }

    override fun onPhotoLiked(photo: Photo) {
        viewModel.onPicLiked(photo)
        viewModel.incrementTotalClick()
    }
}
