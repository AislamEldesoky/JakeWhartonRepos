package com.example.jakewhartonrepos.data.model
import com.google.gson.annotations.SerializedName

data class ReposItem(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("private")
    val `private`: Boolean
)