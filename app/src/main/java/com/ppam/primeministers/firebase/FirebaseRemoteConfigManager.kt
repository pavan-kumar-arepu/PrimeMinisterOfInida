package com.ppam.primeministers.firebase

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.ppam.primeministers.Constants

object FirebaseRemoteConfigManager {
    private val firebaseRemoteConfig = Firebase.remoteConfig

    fun init() {
        // Initialize Firebase Remote Config
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600 // Set your desired fetch interval
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun fetchConfigData(onSuccess: (String) -> Unit, onFailure: (Exception) -> Unit) {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val json = firebaseRemoteConfig.getString(Constants.REMOTE_CONFIG_LEADERS_KEY)
                    onSuccess(json)
                } else {
                    onFailure(task.exception!!)
                }
            }
    }
}