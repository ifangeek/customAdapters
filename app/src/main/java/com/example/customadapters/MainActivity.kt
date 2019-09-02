package com.example.customadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    lateinit var postAdapter : PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postAdapter = PostAdapter()
      //  postAdapter.setListener(this)

        rvPost.apply {
            val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            layoutManager = linearLayoutManager
            adapter = postAdapter
        }
        btnAddMore.setOnClickListener {
            fillView()
        }

    }

    fun fillView(){
        postAdapter.addPost(PostData("",""))
    }

  /*  override fun removeItem() {
    }*/
}
