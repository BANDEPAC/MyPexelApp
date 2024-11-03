package com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.loc.mypexelapp.R
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme

val DEFAULT_INDICATOR_HEIGHT = 4.dp

@Composable
fun AnimatedBottomBar(
    modifier: Modifier = Modifier,
    bottomBarHeight: Dp = 64.dp,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    containerShape: Shape = RectangleShape,
    selectedItem: Int? = null,
    itemSize: Int? = null,
    indicatorColor: Color = MaterialTheme.colorScheme.secondary,
    indicatorHeight: Dp = DEFAULT_INDICATOR_HEIGHT,
    animationSpec: AnimationSpec<Dp> =
        spring(
            dampingRatio = 1f,
            stiffness = Spring.StiffnessMediumLow,
        ),
    indicatorShape: RoundedCornerShape = RoundedCornerShape(25.dp),
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
        modifier = modifier,
        shape = containerShape,
    ) {
        BoxWithConstraints(
            modifier =
            Modifier
                .fillMaxWidth()
        ) {
            val calculatedPadding: Dp

            selectedItem?.let {
                itemSize?.let {
                    val maxWidth = this.maxWidth
                    calculatedPadding = (maxWidth / (itemSize.takeIf { it != 0 } ?: 1))
                    val indicatorOffset: Dp by animateDpAsState(
                        targetValue = calculatedPadding * selectedItem,
                        animationSpec = animationSpec,
                        label = "indicator",
                    )

                    LineIndicator(
                        indicatorOffset = indicatorOffset,
                        arraySize = 23.dp,
                        indicatorHeight = indicatorHeight,
                        indicatorColor = indicatorColor,
                        modifier =
                        Modifier
                            .align(Alignment.TopStart)
                            .padding(start = calculatedPadding / 2 - 12.dp),
                        indicatorShape = indicatorShape,
                    )


                }

            }

        }

            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(bottomBarHeight),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = content,
            )
        }
}

@Preview
@Composable
private fun AnimatedBottomBarTest() {

    val test = listOf(
        BottomItem(
            iconSelected = R.drawable.ic_homeactive,
            iconNotSelected = R.drawable.ic_homeinactive
    ),
        BottomItem(
            iconSelected = R.drawable.ic_bookmarkactive,
            iconNotSelected = R.drawable.ic_bookmarkinactive
        ),
    )

    MyPexelAppTheme {
        val selectedItem = remember { mutableIntStateOf(0) }
        val itemSize = test.size

        AnimatedBottomBar(
            selectedItem = selectedItem.value,
            itemSize = itemSize
        ) {
            test.forEachIndexed { index, bottomItem ->
                NavigationBarItem(
                    selected = selectedItem.value == index,
                    onClick = {
                        selectedItem.value = index
                    },
                    icon = if (selectedItem.value == index) bottomItem.iconSelected else bottomItem.iconNotSelected,
                )
            }
        }
    }

}
