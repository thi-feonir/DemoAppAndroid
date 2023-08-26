package com.example.logic.hashtag

import com.example.domainmodels.HashTag
import com.example.repositories.hashtag.HashtagRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class GetListOfHashTagsUseCase(private val hashtagRepository: HashtagRepository) {
    val hashtags: Observable<List<HashTag>>
        get() {
            return hashtagRepository.hashtagList
        }

    fun reload(): Completable {
        return hashtagRepository.fetchHashtagsFromApi()
    }
}