package com.example.playlist_maker.data.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import com.example.playlist_maker.domain.models.Track
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecentTracksStorage(context: Context) {

    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val type = object : TypeToken<List<Track>>() {}.type

    fun save(tracks: List<Track>) {
        sharedPrefs.edit()
            .putString(KEY_RECENT_TRACKS, gson.toJson(tracks))
            .apply()
    }

    fun load(): List<Track> {
        return gson.fromJson(
            sharedPrefs.getString(KEY_RECENT_TRACKS, null),
            type
        ) ?: emptyList()
    }

    fun clear() {
        sharedPrefs.edit()
            .remove(KEY_RECENT_TRACKS)
            .apply()
    }

    companion object {
        private const val PREFS_NAME = "recent_tracks_prefs"
        private const val KEY_RECENT_TRACKS = "recent_tracks"
    }
}