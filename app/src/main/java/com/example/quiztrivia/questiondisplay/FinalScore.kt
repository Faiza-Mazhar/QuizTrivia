package com.example.quiztrivia.questiondisplay

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FinalScore (var rightQuestion: Int, var totalQuestion: Int) : Parcelable {

    override fun toString(): String {
        return "You answered ${this.rightQuestion} questions correctly out of ${this.totalQuestion}"
    }
}