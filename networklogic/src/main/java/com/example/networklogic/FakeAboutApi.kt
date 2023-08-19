package com.example.networklogic

import com.example.interfaces.ITravelAdvisoriesAbout
import io.reactivex.rxjava3.core.Observable

class FakeAboutApi: ITravelAdvisoriesAbout {
    override fun getAboutMessage(): Observable<String> {
        return Observable.fromSupplier {
            "I am the DemoAndroidApp from PSS. " +
                    "\nMy goal is to provide a briefly vision of our architecture " +
                    "and how we usually design our Android Applications." +
                    "\nWe are following a MVVM architecture guided by Clean and SOLID principles." +
                    "\nUI built on top of Compose and controlled as a StateMachine." +
                    "\nRxJava to make our architecture Event based." +
                    "\nWe like to follow TDD/BDD/DDD methodologies."
        }
    }
}