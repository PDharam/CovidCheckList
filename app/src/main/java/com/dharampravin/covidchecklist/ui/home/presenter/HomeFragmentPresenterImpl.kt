package com.dharampravin.covidchecklist.ui.home.presenter

import com.dharampravin.covidchecklist.ui.home.interactor.HomeFragmentInteractor
import com.dharampravin.covidchecklist.ui.home.interactor.HomeFragmentInteractorImpl
import com.dharampravin.covidchecklist.ui.home.view.HomeFragmentView


class HomeFragmentPresenterImpl(val view: HomeFragmentView) : HomeFragmentPresenter {
    private var interactor: HomeFragmentInteractor = HomeFragmentInteractorImpl(this)
}