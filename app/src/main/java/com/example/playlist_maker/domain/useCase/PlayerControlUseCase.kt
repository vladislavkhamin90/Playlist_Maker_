package com.example.playlist_maker.domain.useCase

import com.example.playlist_maker.domain.models.Track
import com.example.playlist_maker.domain.repos.PlayerRepository

class PlayerControlUseCase(private val repository: PlayerRepository) {

    fun prepareAndPlay(track: Track, onPrepared: () -> Unit) {
        repository.prepare(track) {
            repository.start()
            onPrepared()
        }
    }

    fun togglePlayPause() {
        if (repository.isPlaying()) {
            repository.pause()
        } else {
            repository.start()
        }
    }

    fun getCurrentPosition() = repository.getCurrentPosition()
    fun getCurrentTrack() = repository.getCurrentTrack()
    fun releasePlayer() = repository.release()
}