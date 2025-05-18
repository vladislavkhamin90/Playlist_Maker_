package com.example.playlist_maker.data

import com.example.playlist_maker.data.dto.TrackDto
import com.example.playlist_maker.domain.models.Track

class TrackMapper {
    private fun map(dto: TrackDto): Track {
        return Track(
            trackId = dto.trackId,
            trackName = dto.trackName,
            artistName = dto.artistName,
            trackTimeMillis = dto.trackTimeMillis,
            artworkUrl100 = dto.artworkUrl100,
            collectionName = dto.collectionName,
            releaseDate = dto.releaseDate,
            primaryGenreName = dto.primaryGenreName,
            country = dto.country,
            previewUrl = dto.previewUrl,
        )
    }

    fun mapList(dtoList: List<TrackDto>): List<Track> {
        return dtoList.map { map(it) }
    }
}