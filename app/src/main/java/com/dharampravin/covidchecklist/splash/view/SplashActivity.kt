package com.dharampravin.covidchecklist.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.dashboard.view.DashboardActivity

class SplashActivity : AppCompatActivity(), SplashView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    override fun init() {
        goToDashbaord()
    }


    override fun goToDashbaord() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, DashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }, 2000)
    }
}
