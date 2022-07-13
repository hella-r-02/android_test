package com.sirius.test_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sirius.test_app.adapters.ReviewsRecyclerViewAdapter
import com.sirius.test_app.adapters.StarsRecyclerViewAdapter
import com.sirius.test_app.adapters.TagsRecyclerViewAdapter
import com.sirius.test_app.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val dataModel = DataModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBinding()

        setAdapterForStarsRecyclerView(binding.stars)
        setAdapterFoTagsRecyclerView()
        setAdapterForReviewsRecyclerView()
        setAdapterForStarsRecyclerView(binding.reviewStars)
    }

    @SuppressLint("SetTextI18n")
    private fun initBinding() {
        val imageHeader: ImageView = findViewById(R.id.image_header)
        initImageHeader()

        val appTitle: TextView = findViewById(R.id.app_title)
        appTitle.text = dataModel.name

        val appIcon: ImageView = findViewById(R.id.app_img)
        initAppIcon()

        val description: TextView = findViewById(R.id.description)
        description.text = dataModel.description

        val stars: RecyclerView = findViewById(R.id.stars)
        setLinearLayoutManager(stars, LinearLayoutManager.HORIZONTAL)

        val reviewsCount: TextView = findViewById(R.id.reviews_count)
        reviewsCount.text = dataModel.gradeCnt

        val tags: RecyclerView = findViewById(R.id.tags)
        setLinearLayoutManager(tags, LinearLayoutManager.HORIZONTAL)

        val reviews: RecyclerView = findViewById(R.id.reviews)
        setLinearLayoutManager(reviews, LinearLayoutManager.VERTICAL)

        val rating: TextView = findViewById(R.id.rating)
        rating.text = dataModel.rating.toString()

        val reviewStars: RecyclerView = findViewById(R.id.review_stars)
        setLinearLayoutManager(reviewStars, LinearLayoutManager.HORIZONTAL)

        val evaluationCount: TextView = findViewById(R.id.reviewers_count)
        evaluationCount.text = dataModel.gradeCnt + " Reviews"
    }

    private fun initImageHeader() {
        Glide.with(this)
            .load(dataModel.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .into(binding.imageHeader)
    }

    private fun initAppIcon() {
        Glide.with(this)
            .load(dataModel.logo)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .into(binding.appImg)
    }


    private fun setLinearLayoutManager(recyclerView: RecyclerView, orientation: Int) {
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            orientation, false
        )

    }

    private fun setAdapterForStarsRecyclerView(recyclerView: RecyclerView) {
        with(recyclerView) {
            adapter = StarsRecyclerViewAdapter(dataModel.rating.roundToInt())
        }
    }

    private fun setAdapterFoTagsRecyclerView() {
        with(binding.tags) {
            adapter = TagsRecyclerViewAdapter(dataModel.tags)
        }
    }

    private fun setAdapterForReviewsRecyclerView() {
        with(binding.reviews) {
            adapter = ReviewsRecyclerViewAdapter(dataModel.reviews)
        }
    }
}