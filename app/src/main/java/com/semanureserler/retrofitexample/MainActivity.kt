package com.semanureserler.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.semanureserler.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private  lateinit var postAdapter:PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()
        getAllPosts()
    }
private  fun setupRv(){
    postAdapter= PostAdapter()
    binding.recyclerView.apply {
        layoutManager=LinearLayoutManager(this@MainActivity)
        adapter=postAdapter
        setHasFixedSize(true)
    }
}
    private fun getAllPosts(){
        lifecycleScope.launchWhenCreated {
            val response=RetrofitInstance.retrofit.getAllPosts()
            if (response.isSuccessful&&response.body()!=null){
                postAdapter.differ.submitList(response.body())
                Log.d("response","getallposts:${response.body()}")
            }else{
                Toast.makeText(this@MainActivity,"error code:${response.code()}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}