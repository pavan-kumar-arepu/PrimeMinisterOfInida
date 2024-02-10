package com.ppam.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.navigation.LeaderAppNavigation
import com.ppam.myapplication.screens.LeaderListScreen
import com.ppam.myapplication.ui.theme.MyApplicationTheme
import com.ppam.myapplication.viewmodel.LeaderViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val leaderViewModel: LeaderViewModel = viewModel() // Assuming you have a LeaderViewModel

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LeaderAppNavigation(navController = navController,
                        leaderViewModel = leaderViewModel)
                }
            }
        }
    }
}
