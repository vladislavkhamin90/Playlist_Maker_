package com.example.playlist_maker.domain.repos

import com.example.playlist_maker.domain.models.Track

interface TrackRepository {
    fun searchTracks(query: String, callback: (List<Track>) -> Unit)
    fun getRecentTracks(): List<Track>
    fun addToRecent(track: Track)
    fun clearRecent()
}