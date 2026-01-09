package com.geeks.counter5.data.repository

import com.geeks.counter5.data.datasource.CountDataSource
import com.geeks.counter5.data.mapper.toDomain
import com.geeks.counter5.domain.model.Count
import com.geeks.counter5.domain.repository.CountRepository

class CountRepositoryImpl(
    private val countApi: CountDataSource
) : CountRepository {
    override fun increment() {
        countApi.increment()
    }

    override fun decrement() {
        countApi.decrement()
    }

    override fun getCount(): Count {
        return countApi.getCount().toDomain()
    }

    override fun reset() {
        countApi.reset()
    }

}