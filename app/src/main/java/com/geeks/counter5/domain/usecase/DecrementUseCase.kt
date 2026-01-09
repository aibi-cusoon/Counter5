package com.geeks.counter5.domain.usecase

import com.geeks.counter5.domain.repository.CountRepository

class DecrementUseCase(
    private val repository: CountRepository
) {
    operator fun invoke() = repository.decrement()
}