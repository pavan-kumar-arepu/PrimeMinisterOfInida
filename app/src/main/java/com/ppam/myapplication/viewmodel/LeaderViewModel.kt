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
class LeaderViewModel() : ViewModel() {

    private val _leaderRepository: LeaderRepository

    init {
        _leaderRepository = LeaderRepository()
    }
    /**
     * Retrieves a list of leaders from the repository.
     *
     * @return A list of leaders.
     */
    fun getLeaders(): List<Leader> {
        return _leaderRepository.getLeaders()
    }

    /**
     * Retrieves a leader by ID from the repository.
     *
     * @param id The ID of the leader to retrieve.
     * @return The leader with the specified ID, or null if not found.
     */
    fun getLeaderById(id: Int): Leader? {
        return _leaderRepository.getLeaderById(id)
    }
}