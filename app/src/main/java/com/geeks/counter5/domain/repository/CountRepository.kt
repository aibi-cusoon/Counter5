package com.geeks.counter5.domain.repository

import com.geeks.counter5.data.model.CountDto
import com.geeks.counter5.domain.model.Count

interface CountRepository {
    fun increment()
    fun decrement()
    fun getCount(): Count
    fun reset()
}