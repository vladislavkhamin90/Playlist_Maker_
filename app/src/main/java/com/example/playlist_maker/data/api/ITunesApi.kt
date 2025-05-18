package com.example.playlist_maker.data.api

import com.example.playlist_maker.data.dto.TrackDto
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {
    @GET("/search?entity=song")
    fun search(@Query("term") text: String): Call<SongsResponse>
}

data class SongsResponse(@SerializedName("results") val results: List<TrackDto>)