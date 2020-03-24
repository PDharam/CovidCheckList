package com.dharampravin.covidchecklist.calculate_corona_score.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dharampravin.covidchecklist.R

class CalculateCoronaScoreActivity : AppCompatActivity(), CalculateCoronaScoreView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_corona_score)
        init()
    }

    override fun init() {

    }
}
