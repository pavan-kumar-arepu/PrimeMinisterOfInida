package com.ppam.primeministers.data

/**
 * Object for providing dummy data for leaders.
 */
object DummyData {

    /**
     * Retrieves dummy data for leaders.
     *
     * @return Dummy data for leaders.
     */
    fun getDummyLeaders(): List<Leader> {
        return listOf(
            Leader(
                id = 1,
                name = "Jawaharlal Nehru Test",
                pmNumber = "1 Time - 1st",
                party = "Indian National Congress",
                rulingPeriod = "15 Aug 1947 - 27 May 1964",
                about = "Jawaharlal Nehru was born on 14 November 1889 in Allahabad, British India. His father, Motilal Nehru, a self-made wealthy barrister of Kashmiri Pandit origin, served twice as president of the Indian National Congress, in 1919-20 and 1928-29. His mother, Swarup Rani Thussu, came from a Kashmiri Pandit family settled in Lahore. Jawaharlal was the eldest of three children. The elder of his two sisters, Vijaya Lakshmi, held political office and became president of the United Nations General Assembly. His youngest sister, Krishna Hutheesing, became a noted writer and biographer.",
                achievements = "1955 - Bharat Ratna",
                logo = "nehru",
                signatureLogo = "Jawahar-Sign"
            ),
            Leader(
                id = 2,
                name = "Gulzarilal Nanda",
                pmNumber = "2 Times - 2nd, 4th",
                party = "Indian National Congress",
                rulingPeriod = "27 May 1964 - 9 Jun 1964",
                about = "Gulzarilal Nanda (4 July 1898– 15 January 1998) was an Indian politician and economist who specialised in labour issues. He was the Interim Prime Minister of India for two 13-day tenures following the deaths of Jawaharlal Nehru in 1964 and Lal Bahadur Shastri in 1966 respectively. Both his terms ended after the ruling Indian National Congress's parliamentary party elected a new prime minister.",
                achievements = "He was awarded the Bharat Ratna, India's highest civilian award, in 1997",
                logo = "sastri",
                signatureLogo = ""
            )
            // Add more leaders similarly
        )
    }
}