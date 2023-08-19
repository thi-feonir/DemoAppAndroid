package com.example.interfaces

import io.reactivex.rxjava3.core.Observable

interface ITravelAdvisoriesAbout {
    fun getAboutMessage(): Observable<String>
}