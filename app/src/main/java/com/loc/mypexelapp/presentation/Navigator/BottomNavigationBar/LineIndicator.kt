package com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp


@Composable
internal fun LineIndicator(
    indicatorOffset: Dp,
    arraySize: Dp,
    indicatorColor: Color,
    indicatorHeight: Dp,
    modifier: Modifier,
    indicatorShape: RoundedCornerShape,
) {
    Box(
        modifier =
        modifier
            .height(indicatorHeight)
            .width(arraySize)
            .offset(
                x = indicatorOffset,
            )
            .clip(shape = indicatorShape)
            .background(color = indicatorColor, shape = indicatorShape),
    )
}


@Preview
@Composable
private fun OvalTest() {

}