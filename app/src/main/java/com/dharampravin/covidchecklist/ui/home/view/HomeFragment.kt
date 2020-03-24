package com.dharampravin.covidchecklist.ui.home.view

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.corona_checklist.view.CoronaCheckListActivity
import com.dharampravin.covidchecklist.dashboard.view.DashboardActivity
import com.dharampravin.covidchecklist.ui.home.presenter.HomeFragmentPresenter
import com.dharampravin.covidchecklist.ui.home.presenter.HomeFragmentPresenterImpl
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment(), HomeFragmentView, View.OnClickListener {
    private lateinit var homeFragmentPresenter: HomeFragmentPresenter
    private var isInitialSpinner = true;
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
        spn_language.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!isInitialSpinner)
                    setLanguage(position)
                else
                    isInitialSpinner = false

            }
        }
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

    private fun setLanguage(position: Int) {
        var lang = "en"
        lang = when (position) {
            0 -> "en"
            1 -> "hi"
            2 -> "mr"
            else -> "en"
        }

        val myLocale = Locale(lang)
        val res: Resources = resources
        val dm: DisplayMetrics = res.getDisplayMetrics()
        val conf: Configuration = res.getConfiguration()
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
        val refresh = Intent(activity, DashboardActivity::class.java)
        activity?.finish()
        activity?.startActivity(refresh)
    }

}
