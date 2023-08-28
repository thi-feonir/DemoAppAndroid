package com.example.interfaces

import com.example.domainmodels.HashTag
import com.example.dtos.HashtagDTO
import com.example.interfaces.HashtagApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MockHashTagApi : HashtagApi {
    override fun fetchHashtags(): Observable<List<HashtagDTO>> {
        return Observable.just(
            listOf(
                HashtagDTO(id = "1", text = "#GayPride"),
                HashtagDTO(id = "2", text = "#LGBTQI+"),
                HashtagDTO(id = "2", text = "#Trans"),
                HashtagDTO(id = "2", text = "#Queer"),
                HashtagDTO(id = "2", text = "#Lesbians"),
                HashtagDTO(id = "2", text = "#Pride"),
                HashtagDTO(id = "2", text = "#PrideFlag"),
                HashtagDTO(id = "2", text = "#Scruff"),
            )
        ).observeOn(Schedulers.computation())
    }
}