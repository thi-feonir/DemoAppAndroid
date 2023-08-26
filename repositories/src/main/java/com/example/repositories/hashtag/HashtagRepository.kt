package com.example.repositories.hashtag

import com.example.domainmodels.HashTag
import com.example.interfaces.HashtagApi
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class HashtagRepository(private val hashtagApi: HashtagApi) {

    private var _hashtagList: BehaviorSubject<List<HashTag>> =
        BehaviorSubject.createDefault(emptyList())
    val hashtagList: Observable<List<HashTag>> = _hashtagList

    fun fetchHashtagsFromApi(): Completable {
        return hashtagApi.fetchHashtags().doOnNext {
            this._hashtagList.onNext(it.map { dto ->
                HashTag(
                    id = dto.id, text = dto.text
                )
            })
        }.ignoreElements().onErrorResumeNext { Completable.error(it) }
    }
}