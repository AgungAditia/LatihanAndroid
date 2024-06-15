package com.agungaditia.latihanandroid.api.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.agungaditia.latihanandroid.api.adapter.ReviewAdapter
import com.agungaditia.latihanandroid.api.models.CustomerReviewsItem
import com.agungaditia.latihanandroid.api.models.PostReviewResponse
import com.agungaditia.latihanandroid.api.models.Restaurant
import com.agungaditia.latihanandroid.api.models.RestaurantResponse
import com.agungaditia.latihanandroid.api.retrofit.ApiConfig
import com.agungaditia.latihanandroid.databinding.ActivityRestaurantBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding

    companion object {
        private const val TAG = "RestaurantActivity"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val restaurantViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[RestaurantViewModel::class.java]
        restaurantViewModel.restaurant.observe(this) { restaurant ->
            setRestaurantData(restaurant)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)
//        findRestaurant()

        restaurantViewModel.listReview.observe(this) { customerReview ->
            setReviewData(customerReview)
        }

        restaurantViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        // Untuk menampilkan snackbar tanpa Event
//        restaurantViewModel.snackBar.observe(this) {
//            Snackbar.make(window.decorView.rootView, it, Snackbar.LENGTH_SHORT).show()
//        }

        // Dengan Event
        restaurantViewModel.snackBar.observe(this) {
            // Untuk Mengambil snackbar yang sudah di handle dari ViewModel -> Events
            it.getContentIfNotHandle()
                ?.let { snackBar -> // Untuk mencegah snackbar muncul lebih dari 1x
                    Snackbar.make(window.decorView.rootView, snackBar, Snackbar.LENGTH_SHORT).show()
                }
        }

        binding.btnSend.setOnClickListener { view ->
//            postReview(binding.edReview.text.toString())
            restaurantViewModel.postReview(binding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // Dibawah ini adalah Request API
//    private fun findRestaurant() {
//        showLoading(true)
//        // Request Api untuk menampilkan detail restaurant
//        val client = ApiConfig.getApiService().getdetailRestaurant(RESTAURANT_ID)
//        // enqueue -> untuk menalankan request api secara asynchronous di background
//        client.enqueue(object : Callback<RestaurantResponse> {
//            override fun onResponse(
//                call: Call<RestaurantResponse>,
//                response: Response<RestaurantResponse>
//            ) {
//                showLoading(false)
//                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    if (responseBody != null) {
//                        setRestaurantData(responseBody.restaurant)
//                        setReviewData(responseBody.restaurant?.customerReviews)
//                    }
//                } else {
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
//                showLoading(false)
//                Log.e(TAG, "onFailure: ${t.message}")
//            }
//        })
//    }

//    private fun postReview(review: String) {
//        showLoading(true)
//        // Request Api untuk mengirim data review
//        val client =
//            ApiConfig.getApiService().postReviewRestaurant(RESTAURANT_ID, "users123", review)
//        client.enqueue(object : Callback<PostReviewResponse> {
//            override fun onResponse(
//                call: Call<PostReviewResponse>,
//                response: Response<PostReviewResponse>
//            ) {
//                showLoading(false)
//                val responseBody = response.body()
//                if (response.isSuccessful && responseBody != null) {
//                    setReviewData(responseBody.customerReviews)
//                } else {
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<PostReviewResponse>, t: Throwable) {
//                showLoading(false)
//                Log.e(TAG, "onFailure: ${t.message}")
//            }
//
//        })
//    }

    private fun setRestaurantData(restaurant: Restaurant?) {
        binding.tvTitle.text = restaurant?.name
        binding.tvDescription.text = restaurant?.description
        Glide.with(this@RestaurantActivity)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant?.pictureId}")
            .into(binding.ivPicture)
    }

    private fun setReviewData(consumerReviews: List<CustomerReviewsItem?>?) {
        val adapter = ReviewAdapter()
        adapter.submitList(consumerReviews)
        binding.rvReview.adapter = adapter
        binding.edReview.setText("")
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}