package com.dharampravin.covidchecklist.corona_checklist.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.dharampravin.CovidCheckListApp
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.baseActivity.BaseActivity
import com.dharampravin.covidchecklist.corona_checklist.presenter.CoronaCheckListPresenter
import com.dharampravin.covidchecklist.corona_checklist.presenter.CoronaCheckListPresenterImpl
import com.dharampravin.covidchecklist.corona_checklist_score.view.CoronaCheckListScoreActivity
import com.dharampravin.covidchecklist.utils.ChangeLanguageUtil
import com.dharampravin.covidchecklist.utils.DataProvider
import kotlinx.android.synthetic.main.activity_corona_check_list.*

class CoronaCheckListActivity : BaseActivity(), CoronaCheckListView,
    View.OnClickListener {
    private lateinit var calculateCoronaScorePresenter: CoronaCheckListPresenter
    private var covidchecklist = DataProvider.checkListQuestions
    private var currentQuestionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_check_list)
        init()
        setListener()
    }

    private fun setListener() {
        btn_yes.setOnClickListener(this)
        btn_no.setOnClickListener(this)
    }


    override fun init() {
        calculateCoronaScorePresenter = CoronaCheckListPresenterImpl(this)
        setQuestion()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_yes -> yesNoClickPerform(true)
            R.id.btn_no -> yesNoClickPerform(false)
        }
    }

    private fun yesNoClickPerform(isYes: Boolean) {
        covidchecklist[currentQuestionPosition].userAnswerIsYes = isYes
        if (currentQuestionPosition == 11)
            showScoreActivity()
        else {
            currentQuestionPosition++
            setQuestion()
        }
    }

    private fun showScoreActivity() {
        val i = Intent(this, CoronaCheckListScoreActivity::class.java)
        i.putParcelableArrayListExtra(KEY_CHECKLIST_OBJECT, ArrayList(covidchecklist))
        startActivity(i)
        finish()
    }

    private fun setQuestion() {
        tv_question_count.text = "${currentQuestionPosition + 1} / 12"
        tv_question.text = covidchecklist[currentQuestionPosition].question
    }

    override fun attachBaseContext(newBase: Context?) {
        var context = ChangeLanguageUtil.changeLang(newBase, CovidCheckListApp.getApplanguageCode())
        super.attachBaseContext(context)
    }


}
