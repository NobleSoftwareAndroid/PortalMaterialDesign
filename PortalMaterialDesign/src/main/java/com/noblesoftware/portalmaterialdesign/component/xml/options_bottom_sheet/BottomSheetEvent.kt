package com.noblesoftware.portalmaterialdesign.component.xml.options_bottom_sheet

import com.noblesoftware.portalmaterialdesign.model.SelectOption

sealed class BottomSheetEvent {
    data class OnSearch(val keywords: String) : BottomSheetEvent()
    data class InitSelectOptions(
        val options: List<SelectOption>,
    ) : BottomSheetEvent()

    data class OnSelect(val option: SelectOption) : BottomSheetEvent()
}