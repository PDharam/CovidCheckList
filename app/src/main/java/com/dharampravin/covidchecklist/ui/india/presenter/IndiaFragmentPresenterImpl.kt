package com.dharampravin.covidchecklist.ui.india.presenter

import com.dharampravin.covidchecklist.ui.india.interactor.IndiaFragmentInteractor
import com.dharampravin.covidchecklist.ui.india.interactor.IndiaFragmentInteractorImpl
import com.dharampravin.covidchecklist.ui.india.view.IndiaFragmentView


class IndiaFragmentPresenterImpl(val view: IndiaFragmentView) : IndiaFragmentPresenter {
    private var interactor: IndiaFragmentInteractor = IndiaFragmentInteractorImpl(this)
}