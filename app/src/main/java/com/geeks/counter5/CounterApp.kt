package com.geeks.counter5

import android.app.Application
import com.geeks.counter5.di.dataModule
import com.geeks.counter5.di.domainModule
import com.geeks.counter5.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CounterApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CounterApp)
            androidLogger(Level.DEBUG)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}