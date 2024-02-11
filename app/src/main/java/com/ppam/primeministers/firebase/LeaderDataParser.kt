package com.ppam.primeministers.firebase

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.ppam.primeministers.Constants.PREFERENCE_LEADERS_KEY
import com.ppam.primeministers.Constants.SHARED_PREFERENCE_KEY
import com.ppam.primeministers.data.Leader
object LeaderDataParser {

    fun parseJson(json: String): List<Leader> {
        return try {
            val gson = Gson()
            val leaderListType = object : TypeToken<List<Leader>>() {}.type
            gson.fromJson(json, leaderListType)
        } catch (e: JsonSyntaxException) {
            // Handle JSON parsing exception
            e.printStackTrace()
            emptyList() // Return empty list or null as per your error handling strategy
        }
    }

    fun saveLeadersToSharedPreferences(context: Context, leaders: List<Leader>) {
        try {
            val gson = Gson()
            val json = gson.toJson(leaders)
            val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(PREFERENCE_LEADERS_KEY, json).apply()
        } catch (e: Exception) {
            // Handle exception while saving to SharedPreferences
            e.printStackTrace()
        }
    }

    fun getLeadersFromSharedPreferences(context: Context): List<Leader> {
        return try {
            val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
            val json = sharedPreferences.getString(PREFERENCE_LEADERS_KEY, null)
            if (json != null) {
                parseJson(json)
            } else {
                emptyList() // Return empty list if data is not available in SharedPreferences
            }
        } catch (e: Exception) {
            // Handle exception while retrieving from SharedPreferences
            e.printStackTrace()
            emptyList() // Return empty list or null as per your error handling strategy
        }
    }
}
