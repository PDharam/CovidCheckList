package com.dharampravin.covidchecklist.corona_checklist_score.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.corona_checklist.model.CheckListQuestion
import com.dharampravin.covidchecklist.corona_checklist_score.presenter.CoronaCheckListScorePresenter
import com.dharampravin.covidchecklist.corona_checklist_score.presenter.CoronaCheckListScorePresenterImpl
import com.dharampravin.covidchecklist.utils.ResourceUtil
import kotlinx.android.synthetic.main.activity_corona_check_list_score.*

class CoronaCheckListScoreActivity : AppCompatActivity(), CoronaCheckListScoreView,
    View.OnClickListener {
    private var totalPoint: Int = 0
    private lateinit var coronaCheckListScorePresenter: CoronaCheckListScorePresenter
    private lateinit var coronachecklist: MutableList<CheckListQuestion>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_check_list_score)
        getCheckListData()
        init()
        setListener()
        calculateScore()
        showScore()
    }

    override fun init() {
        coronaCheckListScorePresenter = CoronaCheckListScorePresenterImpl(this)
    }

    override fun setListener() {
        btn_close_result_screen.setOnClickListener(this)
    }

    override fun getCheckListData() {
        coronachecklist =
            intent.getParcelableArrayListExtra<CheckListQuestion>(KEY_CHECKLIST_OBJECT)

    }

    override fun calculateScore() {
        for (question in coronachecklist) {
            if (question.userAnswerIsYes)
                totalPoint += question.point
        }
    }

    override fun showScore() {
        tv_score.text = "Your Score: $totalPoint"
        tv_result_value.text = when (totalPoint) {
            in 0..2 -> ResourceUtil.getString(R.string.score_result_1)
            in 3..5 -> ResourceUtil.getString(R.string.score_result_2)
            in 6..12 -> ResourceUtil.getString(R.string.score_result_3)
            in 12..24 -> ResourceUtil.getString(R.string.score_result_4)
            else -> "Unknown"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_close_result_screen -> onBackPressed()
        }
    }


}
