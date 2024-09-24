package com.noblesoftware.portalmaterialdesign.component.xml.options_bottom_sheet

import com.noblesoftware.portalmaterialdesign.model.SelectOption

data class BottomSheetState(
    val selectOptions: List<SelectOption> = listOf(),
    val filteredSelectOptions: List<SelectOption> = listOf(),
    val keywords: String = ""
)