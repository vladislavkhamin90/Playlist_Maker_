package com.example.playlist_maker.data.network

import com.example.playlist_maker.data.dto.TrackSearchResponse
import com.example.playlist_maker.domain.api.TrackRepository
import com.example.playlist_maker.domain.models.Track


class TrackRepositoryImpl(private val networkClient: NetworkClient): TrackRepository {
    override fun search(expression: String): List<Track> {
        val response = networkClient.doRequest(SearchRequest(expression))
        if (response.resultCode == 200) {
            return (response as TrackSearchResponse).results.map {
                Track(
                    it.trackId,
                    it.trackName,
                    it.artistName,
                    it.trackTimeMillis,
                    it.artworkUrl100,
                    it.collectionName,
                    it.releaseDate,
                    it.primaryGenreName,
                    it.country,
                    it.previewUrl) }
        } else {
            return emptyList()
        }
    }

}