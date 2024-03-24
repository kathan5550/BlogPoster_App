package com.example.retrofit_project.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_project.EXTRA_POST_ID
import com.example.retrofit_project.R
import com.example.retrofit_project.databinding.ActivityDetailBinding
import com.example.retrofit_project.edit.EditActivity

private const val TAG="detailactivity"
const val EXTRA_POST = "EXTRA_POST"
class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
   private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val postId=intent.getIntExtra(EXTRA_POST_ID,-1)
        viewModel=ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.post.observe(this, Observer { post ->
            binding.txtid.text="post #${post.id}"
            binding.txttitle.text=post.title
            binding.txtbody.text=post.body
           // binding.userid.text=post.userId.toString()
        })

        viewModel.user.observe(this, Observer { user->
            Log.d(TAG, "User details received: $user")
            binding.txtname.text=user.name
            binding.txtusername.text=user.username
            binding.txtemail.text=user.email
            binding.txtwebsite.text=user.website
        })

            viewModel.getPostDetails(postId)
        }

       override  fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_detail, menu)
           return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean
        {
            if (item.itemId == R.id.miEdit) {
                Log.i(TAG, "Navigate to edit screen")
                viewModel.post.observe(this, Observer { post ->
                    val intent = Intent(this, EditActivity::class.java)
                    intent.putExtra(EXTRA_POST, post)
                    startActivity(intent)
                })
            }
            return super.onOptionsItemSelected(item)
        }
}


