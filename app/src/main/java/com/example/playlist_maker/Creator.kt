package com.example.playlist_maker

import com.example.playlist_maker.data.network.RetrofitNetworkClient
import com.example.playlist_maker.data.network.TrackRepositoryImpl
import com.example.playlist_maker.domain.api.TrackInteractor
import com.example.playlist_maker.domain.api.TrackRepository
import com.example.playlist_maker.domain.impl.TrackInteractorImpl

object Creator {
    private fun getTrackRepository(): TrackRepository{
        return TrackRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideTrackInteractor(): TrackInteractor{
        return TrackInteractorImpl(getTrackRepository())
    }
}