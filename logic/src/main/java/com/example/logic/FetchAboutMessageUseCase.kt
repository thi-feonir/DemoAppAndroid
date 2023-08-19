package com.example.logic

import com.example.repositories.AboutRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class FetchAboutMessageUseCase(private val repository: AboutRepository) {
    val message: Observable<String>
        get() {
            return repository.aboutMessage
        }

    fun reload(): Completable {
        return repository.getAboutMessage()
    }
}