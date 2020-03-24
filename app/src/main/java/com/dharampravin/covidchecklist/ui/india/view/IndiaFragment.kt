package com.dharampravin.covidchecklist.ui.india.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.ui.india.presenter.IndiaFragmentPresenter
import com.dharampravin.covidchecklist.ui.india.presenter.IndiaFragmentPresenterImpl

class IndiaFragment : Fragment(), IndiaFragmentView {

    private lateinit var indiaFragmentPresenter: IndiaFragmentPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_india, container, false)
        return root
    }

    override fun init() {
        indiaFragmentPresenter = IndiaFragmentPresenterImpl(this)
    }
}
