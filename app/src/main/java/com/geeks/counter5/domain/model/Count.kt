package com.geeks.counter5.domain.model

data class Count(
    val count: Int,
    val countOfIncrement: Int,
    val countOfDecrement: Int,
    val typeOfOperation: TypeOfOperations
)