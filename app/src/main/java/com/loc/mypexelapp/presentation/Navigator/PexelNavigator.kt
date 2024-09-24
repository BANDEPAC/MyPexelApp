package com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.loc.mypexelapp.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigator(){
    val BottomNavigationItems = remember {  listOf(
        BottomItem(
            iconSelected = R.drawable.ic_homeactive,
            iconNotSelected = R.drawable.ic_homeinactive
        ),
        BottomItem(
            iconSelected = R.drawable.ic_bookmarkactive,
            iconNotSelected = R.drawable.ic_bookmarkinactive
        )
    ) }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value

    val selectedItem = remember { mutableIntStateOf(0) }
    val itemSize = BottomNavigationItems.size  // Количество элементов в нижней панели

    Scaffold (
        bottomBar = {
            AnimatedBottomBar(
                selectedItem = selectedItem.value,
                itemSize = itemSize
            ) {
                BottomNavigationItems.forEachIndexed { index, bottomItem ->
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
    ) {

    }
}