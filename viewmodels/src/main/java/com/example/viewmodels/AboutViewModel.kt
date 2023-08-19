package com.example.viewmodels

import com.example.domainmodels.ServerStatus
import com.example.errors.CountryListError
import com.example.logic.FetchAboutMessageUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class AboutViewModel(private val fetchAboutMessageUseCase: FetchAboutMessageUseCase) :
    DisposableViewModel() {
    data class AboutState(
        val aboutMessage: String = "",
        val isLoading: Boolean = false,
        val isLoaded: Boolean = false,
        val error: CountryListError? = null,
        val serverStatus: ServerStatus? = null
    )

    private val _state: BehaviorSubject<AboutState> = BehaviorSubject.createDefault(AboutState())
    val state: Observable<AboutState> = _state

    init {
        onPageLoaded()
    }

    private fun onPageLoaded() {
        disposables.add(
            fetchAboutMessageUseCase.reload().subscribe()
        )

        disposables.add(
            fetchAboutMessageUseCase.message.doOnNext {
                _state.onNext(_state.value!!.copy(aboutMessage = it))
            }.subscribe()
        )
    }
}