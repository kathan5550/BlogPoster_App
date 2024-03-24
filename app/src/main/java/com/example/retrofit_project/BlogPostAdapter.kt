package com.example.retrofit_project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_project.Detail.DetailActivity
import com.example.retrofit_project.databinding.ItemBlogPostBinding
import com.example.retrofit_project.models.post



class BlogPostAdapter(
    private val context:Context,
    private val posts: List<post>,
    private val itemClickListner: ItemClickListner): RecyclerView.Adapter<BlogPostAdapter.ViewHolder>() {


        interface ItemClickListner{
            fun onItemClick(post:post)
        }

    inner class ViewHolder(private val binding:ItemBlogPostBinding):RecyclerView.ViewHolder(binding.root) {

        private val tvid = itemView.findViewById<TextView>(R.id.tvid)
        private val tvtitle = itemView.findViewById<TextView>(R.id.tvtitle)
        private val tvbody = itemView.findViewById<TextView>(R.id.tvbody)

        fun bind(post:post)
        {
            binding.tvid.text="post #${post.id}"
            binding.tvtitle.text=post.title
            binding.tvbody.text=post.body
            itemView.setOnClickListener{
                itemClickListner.onItemClick(post)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val binding=ItemBlogPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(posts[position])
    }
}