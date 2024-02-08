package com.ppam.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader
import com.ppam.myapplication.repository.LeaderRepository

class LeaderViewModel(private val repository: LeaderRepository) : ViewModel() {

    fun getLeaders(): List<Leader> {
        return repository.getLeader()
    }
}