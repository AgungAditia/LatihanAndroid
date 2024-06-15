package com.agungaditia.latihanandroid.api.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agungaditia.latihanandroid.api.models.CustomerReviewsItem
import com.agungaditia.latihanandroid.api.models.PostReviewResponse
import com.agungaditia.latihanandroid.api.models.Restaurant
import com.agungaditia.latihanandroid.api.models.RestaurantResponse
import com.agungaditia.latihanandroid.api.retrofit.ApiConfig
import com.agungaditia.latihanandroid.api.util.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantViewModel : ViewModel() {

    private val _restaurant =
        MutableLiveData<Restaurant?>() // MutaleLiveData -> Bisa diubah value nya
    val restaurant: LiveData<Restaurant?> = _restaurant // LiveData -> Tidak bisa diubah value nya

    private val _listReview = MutableLiveData<List<CustomerReviewsItem>?>()
    val listReview: LiveData<List<CustomerReviewsItem>?> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _snackBar =
        MutableLiveData<Event<String>>() // Event agar snackbar tidak muncul terus menerus
    val snackBar: LiveData<Event<String>> = _snackBar

    companion object {
        private const val TAG = "RestaurantViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    init {
        findRestaurant()
    }

    private fun findRestaurant() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getdetailRestaurant(RESTAURANT_ID)
        client.enqueue(object : Callback<RestaurantResponse> {
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                _isLoading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _restaurant.value = response.body()?.restaurant
                    _listReview.value =
                        response.body()?.restaurant?.customerReviews as List<CustomerReviewsItem>?
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }

    fun postReview(review: String) {
        _isLoading.value = true
        // Request Api untuk mengirim data review
        val client =
            ApiConfig.getApiService().postReviewRestaurant(RESTAURANT_ID, "users123", review)
        client.enqueue(object : Callback<PostReviewResponse> {
            override fun onResponse(
                call: Call<PostReviewResponse>,
                response: Response<PostReviewResponse>
            ) {
                _isLoading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _listReview.value = response.body()?.customerReviews

                    // Menggunakan Event agar snackbar tidak muncul terus menerus
                    _snackBar.value = Event(response.body()?.message.toString())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PostReviewResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }
}