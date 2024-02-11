package com.ppam.primeministers.navigation

sealed class LeaderAppScreen(val route: String) {
    object LeaderList : LeaderAppScreen("leaderList")
    object DetailedLeader : LeaderAppScreen("detailedLeader")
}