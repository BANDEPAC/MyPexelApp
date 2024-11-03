package com.loc.mypexelapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loc.mypexelapp.presentation.HomeScreen.HomeScreen
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.AnimatedBottomBar
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.BottomItem
import com.loc.mypexelapp.presentation.Navigator.BottomNavigationBar.NavigationBarItem
import com.loc.mypexelapp.presentation.Navigator.PexelNavigator
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            MyPexelAppTheme {
                PexelNavigator()
            }
        }

    }
}