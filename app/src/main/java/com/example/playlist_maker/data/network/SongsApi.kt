package com.example.playlist_maker.data.network

import com.example.playlist_maker.data.dto.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsApi {
    @GET("/search?entity=song&")
    fun search(@Query("term") expression: String): Call<SearchResponse>
}