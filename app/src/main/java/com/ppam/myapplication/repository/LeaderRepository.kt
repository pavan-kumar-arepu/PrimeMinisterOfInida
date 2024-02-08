package com.ppam.myapplication.repository

import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader

/**
 * Repository for managing leader data.
 */
class LeaderRepository {

    /**
     * Retrieves a list of leaders.
     *
     * @return A list of leaders.
     */
    fun getLeaders(): List<Leader> {
        return DummyData.getDummyLeaders()
    }
}