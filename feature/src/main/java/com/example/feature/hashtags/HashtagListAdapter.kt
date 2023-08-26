package com.example.feature.hashtags

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import com.example.viewmodels.hashtag.HashTagListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HashtagListAdapter(
    viewModel: HashTagListViewModel = getViewModel(),
) {
    val state by viewModel.state.subscribeAsState(HashTagListViewModel.UIState.Finished(hashtagsList = emptyList()))
    
    HashtagListPage(hashtagListState = state)
}