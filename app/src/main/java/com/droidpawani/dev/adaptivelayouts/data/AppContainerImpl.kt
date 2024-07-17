package com.droidpawani.dev.adaptivelayouts.data

import android.content.Context
import com.droidpawani.dev.adaptivelayouts.data.repository.PetsRepository
import com.droidpawani.dev.adaptivelayouts.data.repository.impl.FakePetsRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val postsRepository: PetsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PetsRepository by lazy {
        FakePetsRepository()
    }

}