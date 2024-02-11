package com.ppam.primeministers.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ppam.primeministers.repository.LeaderRepository

class LeaderViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeaderViewModel::class.java)) {
            val context = application.applicationContext
            val repository = LeaderRepository(context)
            return LeaderViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}