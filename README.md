# BlogPost Android Application 

## Description
The BlogPost app is an Android application developed in Kotlin, following the MVVM (Model-View-ViewModel) architecture. It allows users to interact with a blogging platform, and perform CRUD operations on blog posts through a RESTful API using the Retrofit library. The app provides feedback on the status of these operations, indicating success or failure.

## Features
### 1. View Blog Posts:<br>
* See a list of blog posts with titles and summaries.<br>
* Tap on a post to view the full content.<be>

### 2. MVVM Architecture:<br>
* Separation of concerns: Model, View, ViewModel.<br>
* ViewModel manages UI-related data and communicates with the repository.<br>

### 3. Update Post:<br>
* Users can update existing blog posts.<br>
* Implement both PUT and PATCH methods for full and partial updates.<br>
* See status messages indicating whether the update was successful or failed.<br>

### 4. Delete Post:<br>
* Delete unwanted blog posts.<br>
* Confirmation dialog ensures the user intends to delete the post.<br>

### 5. Status Messages:<br>
* Clear status messages for each operation:<br>
* Successful post creation.<br>
* Successful post update.<br>
* Failed post update (with error message).<br>
* Successful post deletion.<br>
* Failed post deletion (with an error message).<br>

### 6. Error Handling:<br>
* Handle network errors gracefully, displaying appropriate messages.<br>
* Display user-friendly messages for API errors.<br>

## Technologies Used:
Kotlin <br>
MVVM architecture<br>
LiveData for data observation and updates<br>
Retrofit for API calls<br>
JSON Parsing with Gson<br>
Dialogs for user interaction<br>


## MVVM Architecture:
The app follows the MVVM (Model-View-ViewModel) architecture pattern:<br>

* Model: Represents the data and business logic.<br>
* View: Represents the UI elements and interacts with the ViewModel.<br>
* ViewModel: Manages UI-related data and communicates with the repository.<br>

## ScreenShots
<img width="286" alt="Screenshot 2024-03-23 at 8 53 33 PM" src="https://github.com/kathan5550/BlogPoster_App/assets/105222761/7106db62-96a5-46c1-9c10-06d812e3ab58">
<img width="286" alt="Screenshot 2024-03-23 at 8 54 14 PM" src="https://github.com/kathan5550/BlogPoster_App/assets/105222761/fe4297c2-fc71-490a-b78f-6b93e9e27cf4"><br>
<img width="287" alt="Screenshot 2024-03-23 at 8 56 10 PM" src="https://github.com/kathan5550/BlogPoster_App/assets/105222761/2c1df67b-b9f4-418c-b49f-6b944eefe145">
<img width="287" alt="Screenshot 2024-03-23 at 8 58 11 PM" src="https://github.com/kathan5550/BlogPoster_App/assets/105222761/7913ec34-ea49-43e2-b30a-10f8cc57f3a7">

## API Setup
The "BlogPost" app utilizes Retrofit, a powerful HTTP client for Android and Java, to interact with a RESTful API. Follow these steps to set up the API in your Android project:

### 1. Retrofit Library Dependency
dependencies {<br>
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'<br>
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'<br>
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")<br>
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")<br>
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")<br>
    implementation("com.google.ai.client.generativeai:generativeai:0.2.2")<br>
}<br>

### 2. Create Retrofit Client
Create a Kotlin file for your Retrofit client, such as ApiClient.kt. This file will define the Retrofit client instance, including the base URL and other configurations.

import retrofit2.Retrofit<br>
import retrofit2.converter.moshi.MoshiConverterFactory<br>

### private const val BASE_URL= "https://jsonplaceholder.typicode.com/"
object RetrofitInstance {<br>

    private val retrofit by lazy {<br>
        Retrofit.Builder()<br>
            .baseUrl(BASE_URL)<br>
            .addConverterFactory(MoshiConverterFactory.create())<br>
            .build()<br>
    }<br>
    val api:BlogPost by lazy {<br>
        retrofit.create(BlogPost::class.java)<br>
    }<br>
}<br>
* BASE_URL is the base URL of your API.<br>
* MoshiConverterFactory is used for JSON serialization and deserialization.<br>
* BlogPost is the interface defining your API endpoints (explained in the next step).<br>
* Website Link for API: https://jsonplaceholder.typicode.com<br>

### 3. Create ApiService Interface
Create an interface to define the API endpoints. This file can be named BlogPost.kt<br>

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Path("id") id: Int, @Body post: Post): Call<Post>

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") id: Int, @Body post: Post): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Call<Void>
}

### 4. Model Class (Post)
You will need a model class to represent the data structure of a blog post. This class can be named Post.kt.<br>
package com.example.retrofit_project.models

import java.io.Serializable

data class post(
    val userId:Int,
    val id:Int,
    val title:String,
    val body:String):Serializable



### 5.  API Endpoint URLs
Make sure to replace https://api.blogpost.com/ with your actual base URL in RetrofitInstance.kt. Additionally, adjust the endpoint URLs in BlogPost.kt to match your API's endpoint structure.

## License
This project is licensed under the MIT License.

## Acknowledgements
* Retrofit<br>
* Gson<br>
* MVVM architecture<br>
* LiveData<br>
* RecyclerView<br>
* Dialogs for user interaction<br>

## Contact
Name: Kathan Patel<br>
Email: kathanpatel63548@gmail.com<br>
LinkedIn Profile: https://www.linkedin.com/in/kathan-patel-b07446237/<br>

