package com.geeks.counter5.di

import com.geeks.counter5.data.datasource.CountDataSource
import com.geeks.counter5.data.repository.CountRepositoryImpl
import com.geeks.counter5.domain.repository.CountRepository
import com.geeks.counter5.domain.usecase.DecrementUseCase
import com.geeks.counter5.domain.usecase.GetCountUseCase
import com.geeks.counter5.domain.usecase.IncrementUseCase
import com.geeks.counter5.domain.usecase.ResetUseCase
import com.geeks.counter5.presentation.count.CountViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule: List<Module> get() = listOf(dataModule, domainModule, presentationModule)

val dataModule = module {
    single { CountDataSource() }
    single<CountRepository> { CountRepositoryImpl(countApi = get()) }

}
val domainModule = module {
    factory { IncrementUseCase(repository = get()) }
    factory { DecrementUseCase(repository = get()) }
    factory { ResetUseCase(repository = get()) }
    factory { GetCountUseCase(repository = get()) }

}
val presentationModule = module {
    viewModel {
        CountViewModel(
            incrementUseCase = get(),
            decrementUseCase = get(),
            resetUseCase = get(),
            getCountUseCase = get()
        )
    }

}