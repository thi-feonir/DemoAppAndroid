package com.example.repositories

import com.example.interfaces.ITravelAdvisoriesAbout
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class AboutRepository(private val travelAdvisoryAbout: ITravelAdvisoriesAbout) {
    private var _aboutMessage: BehaviorSubject<String> = BehaviorSubject.createDefault("")
    val aboutMessage: Observable<String> = _aboutMessage

    fun getAboutMessage(): Completable {

        return travelAdvisoryAbout.getAboutMessage().doOnNext {
                _aboutMessage.onNext(it)
            }.ignoreElements()

    }
}