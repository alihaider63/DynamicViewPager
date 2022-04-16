package com.haider.dynamicviewpager

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WhoReacted(
    val reactionTabTitle: String,
    val userList: ArrayList<User>
): Parcelable
