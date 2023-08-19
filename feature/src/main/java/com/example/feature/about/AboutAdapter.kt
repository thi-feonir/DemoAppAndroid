package com.example.feature.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import com.example.viewmodels.AboutViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun AboutAdapter(
    viewModel: AboutViewModel = getViewModel(),
) {
    val state by viewModel.state.subscribeAsState(AboutViewModel.AboutState())

    AboutPage(state.aboutMessage)
}