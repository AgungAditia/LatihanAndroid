package com.agungaditia.latihanandroid.api.retrofit


import com.agungaditia.latihanandroid.api.models.PostReviewResponse
import com.agungaditia.latihanandroid.api.models.RestaurantResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServices {

    @GET("detail/{id}") // Annotation -> Untuk memanggil detail restaurant
    fun getdetailRestaurant(
        @Path("id") id: String // Untuk mengakses id restaurant
    ): Call<RestaurantResponse>

    @FormUrlEncoded // Annotation -> Untuk mengirim data
    @Headers("Authorization: token 12345") // Annotation -> Untuk mengirim token
    @POST("review") // Annotation -> Untuk mengirim data review
    fun postReviewRestaurant(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("review") review: String,
    ): Call<PostReviewResponse>

}