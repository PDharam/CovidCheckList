package com.dharampravin.covidchecklist.corona_checklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckListQuestion(var question: String, var userAnswerIsYes: Boolean, val point: Int) :
    Parcelable