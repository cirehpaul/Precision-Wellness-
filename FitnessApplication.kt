package com.example.fitness.ui

import android.app.Application
import com.example.fitness.data.AppContainer
import com.example.fitness.data.AppDataContainer

class FitnessApplication: Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this@FitnessApplication)
    }
}