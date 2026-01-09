package com.geeks.counter5.presentation.count

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.counter5.domain.model.Count
import com.geeks.counter5.domain.usecase.DecrementUseCase
import com.geeks.counter5.domain.usecase.GetCountUseCase
import com.geeks.counter5.domain.usecase.IncrementUseCase
import com.geeks.counter5.domain.usecase.ResetUseCase

class CountViewModel(
    private val incrementUseCase: IncrementUseCase,
    private val decrementUseCase: DecrementUseCase,
    private val resetUseCase: ResetUseCase,
    private val getCountUseCase: GetCountUseCase,
): ViewModel() {

    private val _countData = MutableLiveData<Count>()
    val countData: LiveData<Count> = _countData

    init {
        getCount()
    }

    fun increment(){
        incrementUseCase()
        getCount()
    }
    fun decrement(){
        decrementUseCase()
        getCount()
    }
    fun reset(){
        resetUseCase()
        getCount()
    }
    fun getCount(){
        _countData.value = getCountUseCase()
    }
}