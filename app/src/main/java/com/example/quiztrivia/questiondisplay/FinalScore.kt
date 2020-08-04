package com.example.quiztrivia.questiondisplay

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FinalScore (var rightQuestion: Int, var totalQuestion: Int) : Parcelable