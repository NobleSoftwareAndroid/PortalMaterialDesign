package com.noblesoftware.portalmaterialdesign.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SnackbarState(
    val message: String? = null,
    val messageId: Int? = null,
    val isSuccess: Boolean = true
): Parcelable
