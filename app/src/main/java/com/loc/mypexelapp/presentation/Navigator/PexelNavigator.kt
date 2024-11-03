package com.loc.mypexelapp.presentation.Navigator

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.loc.mypexelapp.R
import com.loc.mypexelapp.presentation.HomeScreen.HomeScreen
import com.loc.mypexelapp.presentation.HomeScreen.HomeViewModel
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.AnimatedBottomBar
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.BottomItem
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.NavigationBarItem
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun PexelNavigator(){
    val bottomNavigationItems = remember {  listOf(
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
    val itemSize = bottomNavigationItems.size

    Scaffold (
        bottomBar = {
            AnimatedBottomBar(
                selectedItem = selectedItem.value,
                itemSize = itemSize
            ) {
                bottomNavigationItems.forEachIndexed { index, bottomItem ->
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
        NavHost(navController = navController, startDestination = Route.HomeScreen.route){
            composable(route = Route.HomeScreen.route) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                val homeScreenState = homeViewModel.state.collectAsState()

                HomeScreen(
                    homeState = homeScreenState,
                    queryChange = { homeViewModel.updateQuery(it) },
                    search = {
                        homeViewModel.checkInternetConnection()
                        homeViewModel.searchPhotos()
                             },
                    onRetry = {
                        homeViewModel.checkInternetConnection()
                        homeViewModel.downloadCuratedPhotos()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PexelNavigatorTest() {
    MyPexelAppTheme {
        PexelNavigator()
    }

}