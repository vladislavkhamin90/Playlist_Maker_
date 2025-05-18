package com.example.playlist_maker.domain.useCase

import com.example.playlist_maker.domain.models.Track
import com.example.playlist_maker.domain.repos.TrackRepository

class RecentTracksUseCase(private val repository: TrackRepository) {
    fun getTracks(): List<Track> = repository.getRecentTracks()
    fun addTrack(track: Track) = repository.addToRecent(track)
    fun clear() = repository.clearRecent()
}