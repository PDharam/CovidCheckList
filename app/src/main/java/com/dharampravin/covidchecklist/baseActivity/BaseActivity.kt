package com.dharampravin.covidchecklist.baseActivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.CovidCheckListApp
import com.dharampravin.covidchecklist.utils.ChangeLanguageUtil

open class BaseActivity: AppCompatActivity()
{
    override fun attachBaseContext(newBase: Context?) {
        var context = ChangeLanguageUtil.changeLang(newBase, CovidCheckListApp.getApplanguageCode())
        super.attachBaseContext(context)
    }
}