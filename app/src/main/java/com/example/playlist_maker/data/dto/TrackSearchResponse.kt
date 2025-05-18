package com.example.playlist_maker.data.dto

import com.example.playlist_maker.data.Response
import com.google.gson.annotations.SerializedName

data class TrackSearchResponse(
    @SerializedName("results") val results: List<TrackDto>
): Response()
