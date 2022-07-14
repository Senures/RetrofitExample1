package com.semanureserler.retrofitexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.semanureserler.retrofitexample.databinding.PostItemLayoutBinding

class PostAdapter:RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: PostItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

     private val differCallback=object:DiffUtil.ItemCallback<PostItem>(){
      override fun areItemsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
          return  oldItem.id==newItem.id
      }

      override fun areContentsTheSame(oldItem: PostItem, newItem: PostItem): Boolean {
        return oldItem==newItem
      }

  }

    val differ=AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      return  PostViewHolder(PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost=differ.currentList[position]
        holder.binding.apply {
            tvBody.text=currentPost.body
            tvTitle.text=currentPost.title
        }
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount()=differ.currentList.size


}