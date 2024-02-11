package com.ppam.primeministers.repository

import android.content.Context
import com.ppam.primeministers.data.Leader
import com.ppam.primeministers.firebase.FirebaseRemoteConfigManager
import com.ppam.primeministers.firebase.LeaderDataParser

/**
 * Repository for managing leader data.
 */
class LeaderRepository(private val context: Context) {

    /**
     * Retrieves a list of leaders from a remote source (e.g., Firebase Remote Config).
     *
     * @param onSuccess Callback invoked with the list of leaders on successful fetch.
     * @param onFailure Callback invoked with an exception on fetch failure.
     */
    fun fetchLeadersFromRemoteConfig(
        onSuccess: (List<Leader>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        FirebaseRemoteConfigManager.fetchConfigData(
            onSuccess = { json ->
                val leaders = LeaderDataParser.parseJson(json)
                onSuccess(leaders)
            },
            onFailure = onFailure
        )
    }

    /**
     * Saves a list of leaders to local preferences.
     *
     * @param leaders List of leaders to save.
     */
    fun saveLeadersToLocalPreferences(leaders: List<Leader>) {
        LeaderDataParser.saveLeadersToSharedPreferences(context, leaders)
    }

    /**
     * Retrieves a list of leaders from local preferences.
     *
     * @return A list of leaders stored in local preferences.
     */
    fun getLeadersFromLocalPreferences(): List<Leader> {
        return LeaderDataParser.getLeadersFromSharedPreferences(context)
    }
}
