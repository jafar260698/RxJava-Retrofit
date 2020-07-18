package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.Adapter.PostAdapter
import com.example.kotlinapp.Model.Post
import com.example.kotlinapp.Retrofit.API
import com.example.kotlinapp.Retrofit.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    internal lateinit var JsonApi:API
    internal lateinit var compositable:CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit =RetrofitClient.instance
        JsonApi=retrofit.create(API::class.java)

        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager=LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositable.addAll(JsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts->displaydata(posts)}
        )
    }

    private fun displaydata(posts: List<Post>?) {
      val adapter=PostAdapter(this,posts!!)
      recycler_posts.adapter=adapter
    }


}
