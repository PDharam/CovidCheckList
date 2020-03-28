package com.dharampravin.covidchecklist.dashboard.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.baseActivity.BaseActivity
import com.dharampravin.covidchecklist.dashboard.presenter.DashboardPresenter
import com.dharampravin.covidchecklist.dashboard.presenter.DashboardPresenterImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : BaseActivity(), DashboardView {
    private lateinit var dashboardPresenter: DashboardPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        init()
    }

    override fun init() {
        dashboardPresenter = DashboardPresenterImpl(this)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_india, R.id.navigation_world
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
