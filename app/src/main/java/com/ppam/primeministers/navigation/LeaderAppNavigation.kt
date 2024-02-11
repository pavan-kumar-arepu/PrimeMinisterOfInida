package com.ppam.primeministers.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ppam.primeministers.screens.DetailedLeaderScreen
import com.ppam.primeministers.screens.LeaderListScreen
import com.ppam.primeministers.viewmodel.LeaderViewModel


@Composable
fun LeaderAppNavigation(navController: NavHostController,
                        leaderViewModel: LeaderViewModel) {
    NavHost(navController = navController,
        startDestination = LeaderAppScreen.LeaderList.route) {
        composable(LeaderAppScreen.LeaderList.route) {
            val leaders = leaderViewModel.leaders.observeAsState(emptyList()) // Provide default empty list
            val loaderState  =  leaderViewModel.loading.observeAsState(true)

            LeaderListScreen(
                leaders = leaders.value,
                onItemClick = { leader ->
                    navController.navigate("${LeaderAppScreen.DetailedLeader.route}/${leader.id}")
                },
                isLoading = loaderState.value
            )
        }
        composable("${LeaderAppScreen.DetailedLeader.route}/{leaderId}") { backStackEntry ->
            val leaderId = backStackEntry.arguments?.getString("leaderId")
            val leaders = leaderViewModel.leaders.observeAsState(emptyList()) // Provide default empty list

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