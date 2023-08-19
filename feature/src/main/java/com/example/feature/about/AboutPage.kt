package com.example.feature.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutPage(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(CenterHorizontally)
                .background(color = MaterialTheme.colors.surface),
            textAlign = TextAlign.Justify,
            fontSize = 45.sp,
            text = "Travel Advisories"
        )
        Spacer(Modifier.size(80.dp))
        Text(
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .background(color = MaterialTheme.colors.surface)
                .padding(3.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            text = message
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutPagePreview() {
    AboutPage(message = "testeststetes")
}