package com.example.playlist_maker.data.network

import com.example.playlist_maker.data.Response


interface NetworkClient {
    fun doRequest(dto: Any): Response
}