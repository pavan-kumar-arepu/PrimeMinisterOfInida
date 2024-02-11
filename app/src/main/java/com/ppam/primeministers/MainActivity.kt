package com.ppam.primeministers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ppam.primeministers.navigation.LeaderAppNavigation
import com.ppam.primeministers.ui.theme.MyApplicationTheme
import com.ppam.primeministers.viewmodel.LeaderViewModel
import com.ppam.primeministers.viewmodel.LeaderViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val leaderViewModelFactory = LeaderViewModelFactory(application)
            val leaderViewModel: LeaderViewModel = ViewModelProvider(this, leaderViewModelFactory).get(LeaderViewModel::class.java)
            val navController = rememberNavController()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LeaderAppNavigation(navController = navController, leaderViewModel = leaderViewModel)
                }
            }
        }
    }
}
