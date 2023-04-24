package com.example.navigationdrawer

data class Myapi(
    val comments: List<Comment>,
    val limit: Int,
    val skip: Int,
    val total: Int
)