package com.likelen.bookishbackend.domain

import kotlinx.serialization.Serializable

@Serializable
data class HashTags(val value: List<String>) {
    companion object {
        fun of(value: List<String>): HashTags {
            return HashTags(value)
        }
    }
}


