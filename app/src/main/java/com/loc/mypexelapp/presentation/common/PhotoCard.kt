package com.loc.mypexelapp.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.compose.rememberAsyncImagePainter
import com.loc.mypexelapp.domain.model.Photo
import com.loc.mypexelapp.presentation.Dimens.CardWidth
import kotlin.random.Random

@Composable
fun PhotoCard(photo: Photo) {
    val painter = rememberAsyncImagePainter(model = photo.src.large)

    Card(
        modifier = Modifier
            .height( ((CardWidth * photo.height) / photo.width).dp)
            .clip(MaterialTheme.shapes.extraLarge)
    ) {
        Image(
            painter = painter,
            contentDescription = photo.alt,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun ImageCardTest() {

}