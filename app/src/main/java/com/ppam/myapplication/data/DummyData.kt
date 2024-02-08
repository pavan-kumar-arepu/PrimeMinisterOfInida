package com.ppam.myapplication.data

object DummyData {
    fun getDummyLeaders(): List<Leader> {
        return listOf(
            Leader(
                id = 1,
                name = "Jawaharlal Nehru",
                pmNumber = "1 Time - 1st",
                party = "Indian National Congress",
                rulingPeriod = "15 Aug 1947 - 27 May 1964",
                about = "Jawaharlal Nehru was born on 14 November 1889 in Allahabad.",
                achievements = "1955 - Bharat Ratna",
                logo = "Nehru",
                signatureLogo = "Jawahar-Sign"
            ),
            // Add more leaders as needed
        )
    }
}
