package com.noblesoftware.portalmaterialdesign.model

import com.noblesoftware.portalmaterialdesign.enums.PermissionType

data class ShowPermissionState(
    val isShow: Boolean,
    val isRationale: Boolean,
    val permissionType: PermissionType
)
