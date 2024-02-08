package com.ppam.myapplication.data

/**
 * Data class representing a leader.
 *
 * @property id The unique identifier of the leader.
 * @property name The name of the leader.
 * @property pmNumber The number of times the leader served as Prime Minister and their rank.
 * @property party The political party the leader belongs to.
 * @property rulingPeriod The period during which the leader served as Prime Minister.
 * @property about Information about the leader.
 * @property achievements Notable achievements of the leader.
 * @property logo The filename of the leader's logo image.
 * @property signatureLogo The filename of the leader's signature image.
 */
data class Leader(
    val id: Int,
    val name: String,
    val pmNumber: String,
    val party: String,
    val rulingPeriod: String,
    val about: String,
    val achievements: String,
    val logo: String,
    val signatureLogo: String
)
