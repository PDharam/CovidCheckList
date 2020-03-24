package com.dharampravin.covidchecklist.corona_checklist_score.view

import com.dharampravin.covidchecklist.root.BaseView


interface CoronaCheckListScoreView : BaseView {
    fun getCheckListData()
    fun init()
    fun setListener()
    fun calculateScore()
    fun showScore()

}