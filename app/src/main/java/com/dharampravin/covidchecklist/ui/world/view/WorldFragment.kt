package com.dharampravin.covidchecklist.ui.world.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.ui.world.presenter.WorldFragmentPresenter
import com.dharampravin.covidchecklist.ui.world.presenter.WorldFragmentPresenterImpl

class WorldFragment : Fragment(), WorldFragmentView {

    private lateinit var worldFragmentPresenter: WorldFragmentPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_world, container, false)

        return root
    }

    override fun init() {
        worldFragmentPresenter = WorldFragmentPresenterImpl(this)
    }
}
