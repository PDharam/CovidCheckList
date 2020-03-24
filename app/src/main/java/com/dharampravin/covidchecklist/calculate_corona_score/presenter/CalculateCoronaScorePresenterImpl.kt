package com.dharampravin.covidchecklist.calculate_corona_score.presenter

import com.dharampravin.covidchecklist.calculate_corona_score.interactor.CalculateCoronaScoreInteractor
import com.dharampravin.covidchecklist.calculate_corona_score.interactor.CalculateCoronaScoreInteractorImpl
import com.dharampravin.covidchecklist.calculate_corona_score.view.CalculateCoronaScoreView


class CalculateCoronaScorePresenterImpl(val view: CalculateCoronaScoreView) :
    CalculateCoronaScorePresenter {
    private var interactor: CalculateCoronaScoreInteractor =
        CalculateCoronaScoreInteractorImpl(this)
}