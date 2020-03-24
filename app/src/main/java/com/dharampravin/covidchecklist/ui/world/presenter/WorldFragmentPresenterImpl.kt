package com.dharampravin.covidchecklist.ui.world.presenter

import com.dharampravin.covidchecklist.ui.world.interactor.WorldFragmentInteractor
import com.dharampravin.covidchecklist.ui.world.interactor.WorldFragmentInteractorImpl
import com.dharampravin.covidchecklist.ui.world.view.WorldFragmentView


class WorldFragmentPresenterImpl(val view: WorldFragmentView) : WorldFragmentPresenter {
    private var interactor: WorldFragmentInteractor = WorldFragmentInteractorImpl(this)
}