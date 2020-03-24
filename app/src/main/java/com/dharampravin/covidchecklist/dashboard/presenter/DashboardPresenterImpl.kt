package com.dharampravin.covidchecklist.dashboard.presenter

import com.dharampravin.covidchecklist.dashboard.interactor.DashboardInteractor
import com.dharampravin.covidchecklist.dashboard.interactor.DashboardInteractorImpl
import com.dharampravin.covidchecklist.dashboard.view.DashboardView


class DashboardPresenterImpl(val view: DashboardView) : DashboardPresenter {
    private var interactor: DashboardInteractor = DashboardInteractorImpl(this)
}