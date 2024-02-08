package com.ppam.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader
import com.ppam.myapplication.repository.LeaderRepository

/**
 * ViewModel for managing leader data.
 *
 * @param repository The repository for fetching leader data.
 */
class LeaderViewModel(private val repository: LeaderRepository) : ViewModel() {

    /**
     * Retrieves a list of leaders from the repository.
     *
     * @return A list of leaders.
     */
    fun getLeaders(): List<Leader> {
        return repository.getLeaders()
    }
}