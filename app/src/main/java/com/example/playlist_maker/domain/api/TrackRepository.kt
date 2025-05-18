package com.example.playlist_maker.domain.api

import com.example.playlist_maker.domain.models.Track


interface TrackRepository {
    fun search(expression: String): List<Track>
}