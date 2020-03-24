package com.dharampravin.covidchecklist.corona_checklist_score.presenter

import com.dharampravin.covidchecklist.corona_checklist_score.interactor.CoronaCheckListScoreInteractor
import com.dharampravin.covidchecklist.corona_checklist_score.interactor.CoronaCheckListScoreInteractorImpl
import com.dharampravin.covidchecklist.corona_checklist_score.view.CoronaCheckListScoreView


class CoronaCheckListScorePresenterImpl(val view: CoronaCheckListScoreView) :
    CoronaCheckListScorePresenter {
    private var interactor: CoronaCheckListScoreInteractor =
        CoronaCheckListScoreInteractorImpl(this)
}