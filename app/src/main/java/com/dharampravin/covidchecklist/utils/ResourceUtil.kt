package com.dharampravin.covidchecklist.utils

import com.dharampravin.CovidCheckListApp

object ResourceUtil {
    fun getString(resId: Int) = CovidCheckListApp.getAppContext().getString(resId)

}