package com.example.playlist_maker.data.repos

import com.example.playlist_maker.domain.models.Track
import com.example.playlist_maker.data.api.ITunesApi
import com.example.playlist_maker.data.api.SongsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrackRepositoryImpl(private val api: ITunesApi) {
    fun searchTracks(query: String, callback: (List<Track>) -> Unit) {
        api.search(query).enqueue(object : Callback<SongsResponse> {
            override fun onResponse(call: Call<SongsResponse>, response: Response<SongsResponse>) {
                val tracks = response.body()?.results?.map { dto ->
                    Track(
                        trackId = dto.trackId,
                        trackName = dto.trackName,
                        artistName = dto.artistName,
                        trackTimeMillis = dto.trackTimeMillis,
                        artworkUrl100 = dto.artworkUrl100,
                        collectionName = dto.collectionName,
                        releaseDate = dto.releaseDate,
                        primaryGenreName = dto.primaryGenreName,
                        country = dto.country,
                        previewUrl = dto.previewUrl
                    )
                } ?: emptyList()
                callback(tracks)
            }

            override fun onFailure(call: Call<SongsResponse>, t: Throwable) {
                callback(emptyList())
            }
        })
    }
}