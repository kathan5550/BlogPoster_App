package com.example.retrofit_project.api

import com.example.retrofit_project.models.post
import com.example.retrofit_project.models.user
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.*

interface BlogPost {
     @GET("posts")
    suspend fun getposts(@Query("_page")page:Int = 1, @Query("_limit") limit:Int = 10):List<post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id")postId:Int):post

   @GET("users/{id}")
    suspend fun getUser(@Path("id")userId:Int):user

    // request body contains the complete new version
    @PUT("posts/{id}")
    suspend fun updatePost(@Path("id") postId: Int, @Body post: post): post

    // request body only needs to contain the specific changes to the resource
    @PATCH("posts/{id}")
    suspend fun patchPost(@Path("id") postId: Int, @Body params: Map<String, String>): post

    @DELETE("posts/{id}")
    suspend fun deletePost(@Header("Auth-Token") auth: String, @Path("id") postId: Int)

    @POST("posts/")
    suspend fun createPost(@Body post: post): post

    @FormUrlEncoded
    @POST("posts/")
    suspend fun createPostUrlEncode(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") content: String
    ): post

    //@GET("posts/{id}")
    //fun getPostViaCallback(@Path("id") postId: Int): Call<post>

   // @GET("users/{id}")
    //fun getUserViaCallback(@Path("id") userId: Int): Call<user>

}