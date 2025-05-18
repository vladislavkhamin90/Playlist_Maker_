package com.example.playlist_maker.domain.useCase

import com.example.playlist_maker.domain.repos.SettingsRepository


class ThemeInteractor(private val repository: SettingsRepository) {
    fun toggleTheme() {
        repository.setDarkThemeEnabled(!repository.isDarkThemeEnabled())
    }

    fun isDarkTheme() = repository.isDarkThemeEnabled()
}