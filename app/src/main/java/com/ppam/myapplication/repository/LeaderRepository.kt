package com.ppam.myapplication.repository

import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader

/**
 * Repository for managing leader data.
 */
class LeaderRepository {

    // Assuming your data source is stored in a variable named leaders
    private val leaders: List<Leader> = DummyData.getDummyLeaders()// Initialize your list of leaders here
    /**
     * Retrieves a list of leaders.
     *
     * @return A list of leaders.
     */
    fun getLeaders(): List<Leader> {
        return DummyData.getDummyLeaders()
    }

    /**
     * Retrieves a leader by ID from the repository.
     *
     * @param id The ID of the leader to retrieve.
     * @return The leader with the specified ID, or null if not found.
     */
    fun getLeaderById(id: Int): Leader? {
        return leaders.find { it.id == id }
    }
}