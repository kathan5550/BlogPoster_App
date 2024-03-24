package com.example.retrofit_project

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_project.api.RetrofitInstance
import com.example.retrofit_project.models.post
import com.google.android.material.tabs.TabLayout.TabGravity
import kotlinx.coroutines.launch
import java.lang.Exception



private const val TAG="Mainviewmodel"
class MainViewModel: ViewModel() {

    private val _posts:MutableLiveData<List<post>> = MutableLiveData()
    val posts:LiveData<List<post>>
        get() = _posts

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private val _errormessage= MutableLiveData<String?>(null)
    val errormessage : LiveData<String?>
        get ()= _errormessage

    private var currentpage = 1

    fun getposts(){
        val handler = Handler(Looper.getMainLooper())
        val delayMillilis= 100
        handler.removeCallbacksAndMessages(null)

        handler.postDelayed({
            viewModelScope.launch {
                Log.i(TAG,"Query with page $currentpage")
                _isLoading.value=true
                _errormessage.value=null
                try {
                    val fetchedposts=RetrofitInstance.api.getposts(currentpage)
                    currentpage += 1
                    Log.i(TAG,"Fetched posts: $fetchedposts")
                    val currentposts = _posts.value ?: emptyList()
                    _posts.value = currentposts + fetchedposts

                }
                catch (e: Exception){
                    _errormessage.value=e.message
                    Log.e(TAG,"Exception $e")
                }
                finally {
                    _isLoading.value= false
                }
            } },delayMillilis.toLong())

    }
}