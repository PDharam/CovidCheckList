package com.dharampravin

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.preference.PreferenceManager
import android.util.DisplayMetrics
import android.widget.Toast
import com.dharampravin.covidchecklist.constants.AppConstatants
import java.util.*

class CovidCheckListApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        getLangageCodeFromPreference()
        setAppLanguage()
    }

    companion object {
        private lateinit var instance: CovidCheckListApp

        fun getAppContext(): Context = instance.applicationContext

         fun changeAppLanguage(languageCode:String){
            val myLocale = Locale(languageCode)
            val res: Resources = getAppContext().resources
            val dm: DisplayMetrics = res.displayMetrics
            val conf: Configuration = res.configuration
            conf.locale = myLocale
            res.updateConfiguration(conf, dm)
        }

        fun updateSharedpreferenceLangauge(languageCode:String)
        {
            val preference = PreferenceManager.getDefaultSharedPreferences(getAppContext())
            preference.edit().putString(AppConstatants.LANGUAGE_CODE_KEY,languageCode).apply()
            val langCode = preference.getString(AppConstatants.LANGUAGE_CODE_KEY, "en")
            Toast.makeText(getAppContext(), "Preference code: " + langCode, Toast.LENGTH_LONG).show()
        }

        fun updateSharedpreferenceSelectedLangaugePosition(position: Int)
        {
            val preference = PreferenceManager.getDefaultSharedPreferences(getAppContext())
            preference.edit().putInt(AppConstatants.LANGUAGE_POSITION_KEY,position).apply()

        }

        fun getApplanguageCode():String?{
            return instance.getLangageCodeFromPreference()
        }

        fun getSelectedLaguagePosition():Int
        {
            return instance.getLangageCodePositionFromPreference()
        }
    }



    private fun getLangageCodeFromPreference():String? {
        val preference = PreferenceManager.getDefaultSharedPreferences(getAppContext())
        val langCode = preference.getString(AppConstatants.LANGUAGE_CODE_KEY, "en")
        Toast.makeText(getAppContext(), "Preference code: $langCode", Toast.LENGTH_LONG).show()
        return langCode
    }

    private fun getLangageCodePositionFromPreference():Int {
        val preference = PreferenceManager.getDefaultSharedPreferences(getAppContext())


        return preference.getInt(AppConstatants.LANGUAGE_POSITION_KEY, 0)


    }

    private fun setAppLanguage()
    {
        val myLocale = Locale(getLangageCodeFromPreference())
        val res: Resources = resources
        val dm: DisplayMetrics = res.displayMetrics
        val conf: Configuration = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
    }
}