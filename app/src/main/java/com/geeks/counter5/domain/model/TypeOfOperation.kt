package com.geeks.counter5.domain.model

enum class TypeOfOperations(
    val value: Int
) {
    INCREMENT(1),
    DECREMENT(2),
    RESET(3),
    NONE(0);

    companion object {
        fun toTypeOfOperations(type: Int?): TypeOfOperations {
            return entries.firstOrNull { it.value == type } ?: NONE
        }
    }
}