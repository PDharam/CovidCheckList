package com.dharampravin.covidchecklist.corona_checklist_score.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.corona_checklist.model.CheckListQuestion
import com.dharampravin.covidchecklist.corona_checklist_score.presenter.CoronaCheckListScorePresenter
import com.dharampravin.covidchecklist.corona_checklist_score.presenter.CoronaCheckListScorePresenterImpl
import com.dharampravin.covidchecklist.utils.LogUtils
import com.dharampravin.covidchecklist.utils.ResourceUtil
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_corona_check_list_score.*
import java.util.*
import kotlin.math.roundToInt

class CoronaCheckListScoreActivity : AppCompatActivity(), CoronaCheckListScoreView,
    View.OnClickListener {
    private val TAG = "CoronaCheckListScoreActivity"
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
        setUpPiaChart()
        setPieChartValues()
    }

    override fun init() {
        coronaCheckListScorePresenter = CoronaCheckListScorePresenterImpl(this)
    }

    override fun setListener() {
        btn_exit_result_screen.setOnClickListener(this)
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
            in 12..20 -> ResourceUtil.getString(R.string.score_result_4)
            else -> "Unknown"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_exit_result_screen -> onBackPressed()
        }
    }

    private fun setUpPiaChart() {
        pia_chart.setBackgroundColor(Color.WHITE)
        pia_chart.setUsePercentValues(true)
        pia_chart.getDescription().setEnabled(false)
        pia_chart.setDrawHoleEnabled(true)
        pia_chart.animateY(2000, Easing.EasingOption.EaseInOutCubic)
        pia_chart.getLegend().setEnabled(false)
        pia_chart.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        pia_chart.setHoleColor(resources.getColor(R.color.colorPrimary))
    }

    fun setPieChartValues() {
        LogUtils.i(TAG, "setPieChartValues: Total Point: $totalPoint")
        var positiveScore = ((totalPoint.toFloat() / 20) * 100)
        var negativeScore = (((20 - totalPoint.toFloat()) / 20) * 100)
        LogUtils.i(TAG, "setPieChartValues: POS: $positiveScore, NEG: $negativeScore")

        val values = ArrayList<PieEntry>()
        val coronaLocalString = resources.getString(R.string.corona_probability)
        values.add(PieEntry(positiveScore, "$coronaLocalString ${positiveScore.roundToInt()}%"))
        values.add(PieEntry(negativeScore, ""))
        //values.add(PieEntry(negativeScore, "Negative ${negativeScore.roundToInt()}%"))
        val dataSet = PieDataSet(values, "Enquiry")

        dataSet.selectionShift = 5f
        dataSet.sliceSpace = 3f
        val colors = intArrayOf(
            R.color.positive_score_color,
            R.color.negative_score_color
        )
        dataSet.setColors(colors, this)
        dataSet.setDrawValues(false)
        val data = PieData(dataSet)
        data.setValueTextSize(15f)
        data.setValueTextColor(Color.WHITE)
        pia_chart.setData(data)
        pia_chart.invalidate()
    }
}
