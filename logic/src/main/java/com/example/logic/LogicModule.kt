package com.example.logic
import com.example.logic.hashtag.GetListOfHashTagsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val logicModule = module {
    factoryOf(::CountryDetailsLogic)
    factoryOf(::CountryListLogic)
    factoryOf(::ServerStatusLogic)
    factoryOf(::GetListOfHashTagsUseCase)
}