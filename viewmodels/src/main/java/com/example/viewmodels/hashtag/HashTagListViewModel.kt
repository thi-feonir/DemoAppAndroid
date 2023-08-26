package com.example.viewmodels.hashtag

import androidx.lifecycle.ViewModel
import com.example.domainmodels.HashTag
import com.example.logic.hashtag.GetListOfHashTagsUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class HashTagListViewModel(private val getListOfHashTagsUseCase: GetListOfHashTagsUseCase) :
    ViewModel() {

    sealed class UIState {
        object Loading : UIState()
        class Finished(val hashtagsList: List<HashTag>) : UIState()
        class Error(val errorMessage: String) : UIState()
    }

    private val _state: BehaviorSubject<UIState> = BehaviorSubject.create()
    val state: Observable<UIState> = _state
    private val disposables = CompositeDisposable()

    init {
        screenLoaded()
    }

    private fun screenLoaded() {
        disposables.add(
            getListOfHashTagsUseCase.reload()
                .doOnSubscribe {
                    _state.onNext(UIState.Loading)
                }
                .doOnComplete {
                    getHashtags()
                }
                .subscribe({},
                    { error ->
                        _state.onNext(UIState.Error(errorMessage = error.message!!))
                    }
                )
        )
    }

    private fun getHashtags() {
        disposables.add(
            getListOfHashTagsUseCase.hashtags
                .doOnNext {
                    _state.onNext(UIState.Finished(hashtagsList = it))
                }
                .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}