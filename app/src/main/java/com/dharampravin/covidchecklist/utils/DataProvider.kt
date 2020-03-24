package com.dharampravin.covidchecklist.utils

import com.dharampravin.covidchecklist.R
import com.dharampravin.covidchecklist.corona_checklist.model.CheckListQuestion

object DataProvider {
    var checkListQuestions = mutableListOf(
        CheckListQuestion(ResourceUtil.getString(R.string.question_1), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_2), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_3), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_4), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_5), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_6), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_7), false, 1),
        CheckListQuestion(ResourceUtil.getString(R.string.question_8), false, 2),
        CheckListQuestion(ResourceUtil.getString(R.string.question_9), false, 2),
        CheckListQuestion(ResourceUtil.getString(R.string.question_10), false, 3),
        CheckListQuestion(ResourceUtil.getString(R.string.question_11), false, 3),
        CheckListQuestion(ResourceUtil.getString(R.string.question_12), false, 3)
    )
}