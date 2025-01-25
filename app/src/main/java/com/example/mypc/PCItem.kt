package com.example.mypc

import java.io.Serializable

data class PCItem(
    val image: Int,
    val title: String,
    val description: String,
    val details: String,
    val price: String
) : Serializable
