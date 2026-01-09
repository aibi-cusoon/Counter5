package com.geeks.counter5.data.datasource

import com.geeks.counter5.data.model.CountDto

class CountDataSource {

    private var count = 0
    private var countOfIncrement = 0
    private var countOfDecrement = 0
    private var typeOfOperation = 0

    fun increment() {
        count++
        countOfIncrement++
        typeOfOperation = 1
    }

    fun decrement() {
        count--
        countOfDecrement++
        typeOfOperation = 2
    }

    fun reset() {
        count = 0
        typeOfOperation = 3
    }

    fun getCount() = CountDto(
        count = count,
        countOfIncrement = countOfIncrement,
        countOfDecrement = countOfDecrement,
        typeOfOperation = typeOfOperation

    )

}