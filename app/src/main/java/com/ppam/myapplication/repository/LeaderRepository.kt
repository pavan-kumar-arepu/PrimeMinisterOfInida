package com.ppam.myapplication.repository

import com.ppam.myapplication.data.DummyData
import com.ppam.myapplication.data.Leader

class LeaderRepository {
    fun getLeader(): List<Leader> {
        return DummyData.getDummyLeaders()
    }
}