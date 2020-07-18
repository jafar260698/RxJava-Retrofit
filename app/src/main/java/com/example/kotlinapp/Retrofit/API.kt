package com.example.kotlinapp.Retrofit

import com.example.kotlinapp.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface API {
    @get:GET("posts")
    val posts:Observable<List<Post>>
}