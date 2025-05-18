package com.example.playlist_maker.domain.repos

import com.example.playlist_maker.domain.models.Track

interface PlayerRepository {
    fun prepare(track: Track, onPrepared: () -> Unit)
    fun start()
    fun pause()
    fun release()
    fun getCurrentPosition(): Int
    fun isPlaying(): Boolean
    fun getCurrentTrack(): Track?
}