package com.haider.dynamicviewpager

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val userDp: String,
    val userName: String,
): Parcelable
