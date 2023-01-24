package com.example.sephora.domain.model


import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class CBrand(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String
)