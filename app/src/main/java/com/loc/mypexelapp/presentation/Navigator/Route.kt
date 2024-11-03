package com.loc.mypexelapp.presentation.Navigator

sealed class Route(
    val route: String
) {
    object HomeScreen : Route(route = "Home")

    object DetailsScreen : Route(route = "Home")

    object BookmarksScreen : Route(route = "Home")

}