package com.dharampravin

import android.app.Application
import android.content.Context

class CovidCheckListApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }

    companion object {
        private lateinit var instance: CovidCheckListApp

        fun getAppContext(): Context = instance?.applicationContext
    }

}