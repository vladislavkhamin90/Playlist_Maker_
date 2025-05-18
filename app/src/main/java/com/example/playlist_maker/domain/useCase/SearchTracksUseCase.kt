package com.example.playlist_maker.domain.useCase

import com.example.playlist_maker.domain.models.Track
import com.example.playlist_maker.domain.repos.TrackRepository

class SearchTracksUseCase(private val repository: TrackRepository) {
    fun execute(query: String, callback: (List<Track>) -> Unit) {
        repository.searchTracks(query, callback)
    }
}