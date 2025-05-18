package com.example.playlist_maker.domain.repos

interface SettingsRepository {
    fun setDarkThemeEnabled(enabled: Boolean)
    fun isDarkThemeEnabled(): Boolean
}