package com.dharampravin.covidchecklist.splash.presenter

import com.dharampravin.covidchecklist.splash.interactor.SplashInteractor
import com.dharampravin.covidchecklist.splash.interactor.SplashInteractorImpl
import com.dharampravin.covidchecklist.splash.view.SplashView


class SplashPresenterImpl(val view: SplashView) : SplashPresenter {
    private var interactor: SplashInteractor = SplashInteractorImpl(this)
}