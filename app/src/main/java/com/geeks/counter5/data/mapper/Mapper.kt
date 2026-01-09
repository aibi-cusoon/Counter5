package com.geeks.counter5.data.mapper

import com.geeks.counter5.data.model.CountDto
import com.geeks.counter5.domain.model.Count
import com.geeks.counter5.domain.model.TypeOfOperations

fun CountDto.toDomain() = Count(
    count = count.orDefault(),
    countOfIncrement = countOfIncrement.orDefault(),
    countOfDecrement = countOfDecrement.orDefault(),
    typeOfOperation = TypeOfOperations.toTypeOfOperations(typeOfOperation)
)

fun Int?.orDefault() = this ?: 0