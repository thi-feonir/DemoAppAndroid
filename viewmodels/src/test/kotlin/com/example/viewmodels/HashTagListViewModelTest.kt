package com.example.viewmodels

import com.example.AutoCloseKoinAfterEachExtension
import com.example.domainmodels.HashTag
import com.example.interfaces.networkLogicApiMocks
import com.example.logic.logicModule
import com.example.repositories.repositoriesModule
import com.example.viewmodels.hashtag.HashTagListViewModel
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.assertEquals

@ExtendWith(AutoCloseKoinAfterEachExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class HashTagListViewModelTest : KoinTest {
    private val hashTagListViewModel: HashTagListViewModel by inject()

    @BeforeEach
    fun setup() {
        startKoin {
            loadKoinModules(viewModelModule + logicModule + repositoriesModule + networkLogicApiMocks)
        }
    }

    @AfterEach
    fun cleanup() {
        RxJavaPlugins.setComputationSchedulerHandler(null)
    }

    @Test
    fun `screen is loaded, state is list of hashtags`() {
        val expectedList = listOf(
            HashTag(id = "1", text = "#123"), HashTag(id = "2", text = "#321")
        )

        val stateObserver = hashTagListViewModel.state.test()

        assert(stateObserver.values().last() is HashTagListViewModel.UIState.Finished)

        assertEquals(
            expectedList,
            (stateObserver.values().last() as HashTagListViewModel.UIState.Finished).hashtagsList
        )
    }
}

