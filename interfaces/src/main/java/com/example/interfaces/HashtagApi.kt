package com.example.interfaces

import com.example.dtos.HashtagDTO
import io.reactivex.rxjava3.core.Observable

interface HashtagApi {

    fun fetchHashtags(): Observable<List<HashtagDTO>>
}