package com.dharampravin.covidchecklist.utils

import android.util.Log
import com.dharampravin.covidchecklist.BuildConfig

object LogUtils {
    var VERBOSE: Int = 1
    var DEBUG: Int = 2
    var INFO: Int = 3
    var WARN: Int = 4
    var ERROR: Int = 5

    fun e(tag: String, message: String) {
        log(ERROR, tag, message);
    }

    fun d(tag: String, message: String) {
        log(DEBUG, tag, message);
    }

    fun i(tag: String, message: String) {
        log(INFO, tag, message);
    }

    fun w(tag: String, message: String) {
        log(WARN, tag, message);
    }

    fun v(tag: String, message: String) {
        log(VERBOSE, tag, message);
    }

    private fun log(logType: Int, tag: String, message: String) {
        if (BuildConfig.DEBUG)
            when (logType) {
                VERBOSE -> Log.v(tag, message)
                DEBUG -> Log.d(tag, message)
                INFO -> Log.i(tag, message)
                WARN -> Log.w(tag, message)
                ERROR -> Log.e(tag, message)
            }
    }
}