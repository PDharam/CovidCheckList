package com.dharampravin.covidchecklist.ui.world.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.ui.world.presenter.WorldFragmentPresenter
import com.dharampravin.covidchecklist.ui.world.presenter.WorldFragmentPresenterImpl
import kotlinx.android.synthetic.main.fragment_world.*

class WorldFragment : Fragment(), WorldFragmentView, View.OnClickListener {

    private lateinit var worldFragmentPresenter: WorldFragmentPresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_world, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListners()
    }

    private fun setListners()
    {
        iv_play_video_who_1.setOnClickListener(this)
        iv_play_video_who_2.setOnClickListener(this)
        iv_who_youtube1.setOnClickListener(this)
        iv_who_youtube2.setOnClickListener(this)
    }

    override fun init() {
        worldFragmentPresenter = WorldFragmentPresenterImpl(this)
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.iv_play_video_who_1, R.id.iv_who_youtube1 ->
                playYoutubeVideo(resources.getString(R.string.who_youtube_video1_id))

            R.id.iv_play_video_who_2,R.id.iv_who_youtube2 ->
                playYoutubeVideo(resources.getString(R.string.who_youtube_video2_id))
        }
    }

    private fun playYoutubeVideo(youtubeVideoID:String)
    {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$youtubeVideoID"))

        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$youtubeVideoID")
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }
}
