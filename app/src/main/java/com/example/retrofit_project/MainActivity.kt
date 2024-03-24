package com.example.retrofit_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_project.Detail.DetailActivity
import com.example.retrofit_project.databinding.ActivityMainBinding
import com.example.retrofit_project.models.post

private const val TAG="MainActivity"
const val EXTRA_POST_ID="EXTRA_POST_ID"
class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var blogPostAdapter: BlogPostAdapter
    private val blogposts=  mutableListOf<post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.posts.observe(this, Observer { posts ->
            Log.i(TAG,"Number of Posts: ${posts.size}")
            val numElements = blogposts.size
            blogposts.clear()
            blogposts.addAll(posts)
            blogPostAdapter.notifyDataSetChanged()
            binding.myrecyclerview.smoothScrollToPosition(numElements)
        })


        viewModel.isLoading.observe(this, Observer { isLoading ->
            Log.i(TAG,"isLoading $isLoading")
            binding.progressBar2.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        viewModel.errormessage.observe(this, Observer { errormessage ->
          if(errormessage == null)
          {
              binding.errortxt.visibility = View.GONE
          }
            else
          {
              binding.errortxt.visibility = View.VISIBLE
              Toast.makeText(this, errormessage,Toast.LENGTH_SHORT).show()
          }
        })
        binding.fetchbtn.setOnClickListener{
             viewModel.getposts()

        }


        blogPostAdapter= BlogPostAdapter(this,blogposts,
            object: BlogPostAdapter.ItemClickListner{
                override fun onItemClick(post:post)
                {
                    val intent =Intent(this@MainActivity,DetailActivity::class.java)
                    intent.putExtra(EXTRA_POST_ID,post.id)
                    startActivity(intent)
                }
            })
        binding.myrecyclerview.adapter=blogPostAdapter
        binding.myrecyclerview.layoutManager=LinearLayoutManager(this)
    }
}