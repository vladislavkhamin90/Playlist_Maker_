package com.example.playlist_maker.domain.impl

import com.example.playlist_maker.domain.api.TrackInteractor
import com.example.playlist_maker.domain.api.TrackRepository
import java.util.concurrent.Executors

class TrackInteractorImpl(private val repository: TrackRepository): TrackInteractor {
    private val executor = Executors.newCachedThreadPool()

    override fun searchTrack(expression: String, consumer: TrackInteractor.TrackConsumer) {
        executor.execute {
            consumer.consume(repository.search(expression))
        }
    }
}