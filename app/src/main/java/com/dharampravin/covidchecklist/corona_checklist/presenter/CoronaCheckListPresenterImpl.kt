package com.dharampravin.covidchecklist.corona_checklist.presenter

import com.dharampravin.covidchecklist.corona_checklist.interactor.CoronaCheckListInteractor
import com.dharampravin.covidchecklist.corona_checklist.interactor.CoronaCheckListInteractorImpl
import com.dharampravin.covidchecklist.corona_checklist.view.CoronaCheckListView


class CoronaCheckListPresenterImpl(val view: CoronaCheckListView) :
    CoronaCheckListPresenter {
    private var interactor: CoronaCheckListInteractor =
        CoronaCheckListInteractorImpl(this)
}