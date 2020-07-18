package com.example.kotlinapp.Retrofit

import retrofit2.http.GET
import java.util.*

interface GetData {
    @GET("")
    fun getData():Observable<List<RetroCype>>
}