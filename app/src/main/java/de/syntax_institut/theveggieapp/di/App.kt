package de.syntax_institut.theveggieapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * The application class for initializing dependencies and setting up Koin for dependency injection.
 *
 * This class is executed when the application starts and configures the Koin framework with the required modules.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}