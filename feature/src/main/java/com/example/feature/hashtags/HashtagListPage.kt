package com.example.feature.hashtags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domainmodels.HashTag
import com.example.viewmodels.hashtag.HashTagListViewModel

@Composable
fun HashtagListPage(
    hashtagListState: HashTagListViewModel.UIState
) {
    Box {
        //ProgressIndicator(isLoading = hashtagListState.isLoading)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(alignment = Alignment.Center)
                .background(color = MaterialTheme.colors.surface)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Text(
                    textAlign = TextAlign.Center, fontSize = 30.sp, text = "Hashtag List",
                    style = MaterialTheme.typography.h2
                )
            }
            LazyColumn(
                modifier = Modifier.padding(10.dp)
            ) {
                items((hashtagListState as HashTagListViewModel.UIState.Finished).hashtagsList) { hashtag ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                    ) {
                        Text(
                            hashtag.text,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "HashtagList Preview", widthDp = 300, heightDp = 300)
@Composable
fun HashtagListPagePreview() {
    HashtagListPage(
        hashtagListState = HashTagListViewModel.UIState.Finished(
            hashtagsList = listOf(
                HashTag(id = "1", text = "#GayPride"),
                HashTag(id = "2", text = "#LGBTQI+"),
                HashTag(id = "2", text = "#Trans"),
                HashTag(id = "2", text = "#Queer"),
                HashTag(id = "2", text = "#Lesbians"),
                HashTag(id = "2", text = "#Pride"),
                HashTag(id = "2", text = "#PrideFlag"),
                HashTag(id = "2", text = "#Scruff"),
            )
        ),
    )
}