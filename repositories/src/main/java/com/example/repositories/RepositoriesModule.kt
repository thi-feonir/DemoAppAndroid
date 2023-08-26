package com.example.repositories

import com.example.repositories.hashtag.HashtagRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoriesModule = module {
    singleOf(::CountryDetailsPullBasedRepository)
    singleOf(::CountryListPushBasedRepository)
    singleOf(::ServerStatusPushBasedRepository)
    singleOf(::HashtagRepository)
}
