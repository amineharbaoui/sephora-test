package com.example.sephora.domain.model


import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class ImagesUrl(
    @JsonProperty("small")
    val small: String,
    @JsonProperty("large")
    val large: String
)