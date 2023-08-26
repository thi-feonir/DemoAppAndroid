package com.example.viewmodels

import com.example.viewmodels.hashtag.HashTagListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::AboutViewModel)
    viewModelOf(::CountryListViewModel)
    viewModelOf(::HashTagListViewModel)

    viewModel { params ->
        CountryDetailsViewModel(
            logic = get(),
            regionCode = params.get()
        )
    }
}