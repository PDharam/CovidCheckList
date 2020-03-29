package com.dharampravin.covidchecklist.ui.india.view

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.dharampravin.CovidCheckListApp
import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.ui.india.presenter.IndiaFragmentPresenter
import com.dharampravin.covidchecklist.ui.india.presenter.IndiaFragmentPresenterImpl
import kotlinx.android.synthetic.main.fragment_india.*
import java.io.*


class IndiaFragment : Fragment(), IndiaFragmentView, View.OnClickListener {

    private lateinit var indiaFragmentPresenter: IndiaFragmentPresenter
    val MY_PERMISSIONS_REQUEST_READ_MEDIA = 100

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_india, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners()
    {
        iv_play_video.setOnClickListener(this)
        iv_moh_youtube.setOnClickListener(this)
        iv_moh_pdf.setOnClickListener(this)

    }

    override fun init() {
        indiaFragmentPresenter = IndiaFragmentPresenterImpl(this)
    }



    override fun openPDF() {
        checkPermission()
    }

    override fun openYoutube() {

        val id = resources.getString(R.string.india_youtube_video1_id)
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))

        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id")
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

    private fun checkPermission()
    {
        val permissionCheck = ContextCompat.checkSelfPermission(
            activity!!,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                activity!!,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST_READ_MEDIA
            )
        } else { //Do your work
            openPDFFile()
        }
    }

    fun  openPDFFile()
    {
        val fileBrochure =
            File(Environment.getExternalStorageDirectory().toString() + "/" + "India.pdf")
        if (!fileBrochure.exists()) {
            CopyAssetsbrochure()
        }

        /** PDF reader code */
        /** PDF reader code  */
        val file =
            File(Environment.getExternalStorageDirectory().toString() + "/" + "India.pdf")

        val intent = Intent(Intent.ACTION_VIEW)

        val uri = FileProvider.getUriForFile(activity!!,activity?.application?.packageName + ".provider", file)
        intent.setDataAndType(uri, "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        try {
            activity?.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity, "NO Pdf Viewer", Toast.LENGTH_SHORT).show()
        }
    }


    //method to write the PDFs file to sd card
    private fun CopyAssetsbrochure() {
        val assetManager: AssetManager? = activity?.assets
        var files: Array<String>? = null
        try {
            files = assetManager?.list("")
        } catch (e: IOException) {
            Log.e("tag", e.message)
        }
        for (i in files!!.indices) {
            val fStr = files[i]
            if (fStr.equals("India.pdf", ignoreCase = true)) {
                var `in`: InputStream? = null
                var out: OutputStream? = null
                try {
                    `in` = assetManager?.open(files[i])
                    out = FileOutputStream(
                        Environment.getExternalStorageDirectory().toString() + "/" + files[i]
                    )
                    if (`in` != null) {
                        copyFile(`in`, out)
                    }
                    `in`?.close()
                    `in` = null
                    out.flush()
                    out.close()
                    out = null
                    break
                } catch (e: Exception) {
                    Log.e("tag", e.message)
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun copyFile(`in`: InputStream, out: OutputStream?) {
        val buffer = ByteArray(1024)
        var read: Int
        while (`in`.read(buffer).also { read = it } != -1) {
            out!!.write(buffer, 0, read)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_MEDIA -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openPDFFile()
            } else {
                Toast.makeText(
                    CovidCheckListApp.getAppContext(),
                    "Permission not granted!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
            }
        }
    }

    override fun onClick(view: View?) {

        when(view?.id)
        {
            R.id.iv_play_video, R.id.iv_moh_youtube -> openYoutube()

            R.id.iv_moh_pdf -> checkPermission()
        }
    }
}
