package com.ppam.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ppam.myapplication.screens.DetailedLeaderScreen
import com.ppam.myapplication.screens.LeaderListScreen
import com.ppam.myapplication.viewmodel.LeaderViewModel

@Composable
fun LeaderAppNavigation(navController: NavHostController,
                        leaderViewModel: LeaderViewModel) {
    NavHost(navController = navController,
        startDestination = LeaderAppScreen.LeaderList.route) {
        composable(LeaderAppScreen.LeaderList.route) {
        LeaderListScreen(
            leaders = leaderViewModel.getLeaders(),
            onItemClick = { leader ->
                navController.navigate("${LeaderAppScreen.DetailedLeader.route}/${leader.id}")
            }
        )
    }
        composable("${LeaderAppScreen.DetailedLeader.route}/{leaderId}") { backStackEntry ->
            val leaderId = backStackEntry.arguments?.getString("leaderId")
            leaderId?.toIntOrNull()?.let { id ->
                val leader = leaderViewModel.getLeaderById(id)
                if (leader != null) {
                    DetailedLeaderScreen(leader = leader,
                        onBackPressed = {
                            navController.popBackStack()
                        })
                } else {
                    // Handle the case where the leader is not found, e.g., navigate to an error screen
                    // or display a toast message
                }
            } ?: navController.navigateUp()
        }
    }

}