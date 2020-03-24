package com.dharampravin.covidchecklist.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.dashboard.view.DashboardActivity
import com.dharampravin.covidchecklist.splash.presenter.SplashPresenter
import com.dharampravin.covidchecklist.splash.presenter.SplashPresenterImpl

class SplashActivity : AppCompatActivity(), SplashView {
    private lateinit var splashPresenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    override fun init() {
        splashPresenter = SplashPresenterImpl(this)
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
