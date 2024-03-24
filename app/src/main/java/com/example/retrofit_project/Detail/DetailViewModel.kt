package com.example.retrofit_project.Detail

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_project.api.RetrofitInstance
import com.example.retrofit_project.models.post
import com.example.retrofit_project.models.user
import kotlinx.coroutines.launch

private const val TAG="DetailViewModel"
class DetailViewModel:ViewModel() {

    private val _isLoading =MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _post= MutableLiveData<post>()
    val post:LiveData<post>
        get() = _post

    private  val _user=MutableLiveData<user>()
    val user:LiveData<user>
        get() = _user

   fun getPostDetails(postId:Int)
   {


       val api = RetrofitInstance.api

       val handler = Handler(Looper.getMainLooper())
       val delayMillilis= 100
       handler.removeCallbacksAndMessages(null)

       handler.postDelayed({ viewModelScope.launch {
           _isLoading.value=true
           val fetchedPost =api.getPost(postId)
           val fetchedUser= api.getUser(fetchedPost.userId)
           Log.i(TAG,"fetched user $fetchedUser")
           _post.value=fetchedPost
           _user.value=fetchedUser
           _isLoading.value=false
       }},delayMillilis.toLong())
   }
}