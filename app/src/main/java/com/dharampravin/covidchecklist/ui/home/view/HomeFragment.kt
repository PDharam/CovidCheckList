package com.dharampravin.covidchecklist.ui.home.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.corona_checklist.view.CoronaCheckListActivity
import com.dharampravin.covidchecklist.ui.home.presenter.HomeFragmentPresenter
import com.dharampravin.covidchecklist.ui.home.presenter.HomeFragmentPresenterImpl
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeFragmentView, View.OnClickListener {
    private lateinit var homeFragmentPresenter: HomeFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setListener()
    }

    override fun init() {
        homeFragmentPresenter = HomeFragmentPresenterImpl(this)
    }

    override fun setListener() {
        btn_calculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_calculate -> openCalcuateCoronaScoreActivity()
        }
    }

    private fun openCalcuateCoronaScoreActivity() {
        val i = Intent(activity, CoronaCheckListActivity::class.java)
        startActivity(i)
    }
}
