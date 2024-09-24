package com.noblesoftware.portalmaterialdesign.component.xml.dynamic_bottom_sheet

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.noblesoftware.portalmaterialdesign.R
import com.noblesoftware.portalmaterialdesign.databinding.BottomSheetDialogDynamicBinding
import com.noblesoftware.portalmaterialdesign.enums.BottomSheetActionType
import com.noblesoftware.portalmaterialdesign.util.extension.visibleWhen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class DefaultDynamicBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogDynamicBinding

    private var content: @Composable () -> Unit = {}

    private var buttonFirstEnable: Boolean = true
    private var buttonFirstText: Int = R.string.close
    private var buttonFirstType: BottomSheetActionType = BottomSheetActionType.NEUTRAL
    private var buttonFirstOnClick: () -> Unit = {}

    private var buttonSecondEnable: Boolean = false
    private var buttonSecondText: Int = R.string.okay
    private var buttonSecondType: BottomSheetActionType = BottomSheetActionType.PRIMARY_SOLID
    private var buttonSecondOnClick: () -> Unit = {}
    override fun getTheme(): Int = R.style.ModalBottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.bottom_sheet_dialog_dynamic,
                container,
                false
            )
        binding.lifecycleOwner = viewLifecycleOwner
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // todo set theme before
                content.invoke()
            }
        }
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            (it as BottomSheetDialog).findViewById<CoordinatorLayout>(com.google.android.material.R.id.coordinator)

            val containerLayout =
                it.findViewById<FrameLayout>(com.google.android.material.R.id.container)

            val buttons = bottomSheetDialog.layoutInflater.inflate(
                R.layout.bottom_sheet_dialog_dynamic_action,
                null
            )
            val buttonFirst = buttons.findViewById<MaterialButton>(R.id.btn_first)
            val buttonSecond = buttons.findViewById<MaterialButton>(R.id.btn_second)

            buttonFirst.visibleWhen(buttonFirstEnable)
            buttonSecond.visibleWhen(buttonSecondEnable)
            buttonFirst.setButtonType(requireContext(), buttonFirstType)
            buttonSecond.setButtonType(requireContext(), buttonSecondType)
            buttonFirst.text = ContextCompat.getString(requireContext(), buttonFirstText)
            buttonSecond.text = ContextCompat.getString(requireContext(), buttonSecondText)

            buttonFirst.setOnClickListener {
                buttonFirstOnClick.invoke()
                dismiss()
            }
            buttonSecond.setOnClickListener {
                buttonSecondOnClick.invoke()
                dismiss()
            }

            buttons.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.BOTTOM
            }
            containerLayout?.addView(buttons)
        }
        return bottomSheetDialog
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        fun showDialog(
            fragmentManager: FragmentManager,
            buttonFirstEnable: Boolean = true,
            buttonSecondEnable: Boolean = false,
            @StringRes buttonFirstText: Int = R.string.close,
            @StringRes buttonSecondText: Int = R.string.okay,
            buttonFirstType: BottomSheetActionType = BottomSheetActionType.NEUTRAL,
            buttonSecondType: BottomSheetActionType = BottomSheetActionType.PRIMARY_SOLID,
            buttonFirstOnClick: () -> Unit = {},
            buttonSecondOnClick: () -> Unit = {},
            content: @Composable () -> Unit
        ) {
            DefaultDynamicBottomSheetDialog().apply {
                this.buttonFirstEnable = buttonFirstEnable
                this.buttonSecondEnable = buttonSecondEnable
                this.buttonFirstText = buttonFirstText
                this.buttonSecondText = buttonSecondText
                this.buttonFirstType = buttonFirstType
                this.buttonSecondType = buttonSecondType
                this.buttonFirstOnClick = buttonFirstOnClick
                this.buttonSecondOnClick = buttonSecondOnClick
                this.content = content
            }.show(fragmentManager, DefaultDynamicBottomSheetDialog::class.java.simpleName)
        }
    }
}

private fun MaterialButton.setButtonType(context: Context, buttonType: BottomSheetActionType) {
    when (buttonType) {
        BottomSheetActionType.PRIMARY_SOLID -> {
            this.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary_solid_bg))
            this.strokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary_solid_bg))
            this.setTextColor(ContextCompat.getColor(context, R.color.primary_solid_color))
        }

        BottomSheetActionType.PRIMARY_OUTLINED -> {
            this.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.background_body))
            this.strokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary_solid_bg))
            this.setTextColor(ContextCompat.getColor(context, R.color.primary_solid_bg))
        }

        BottomSheetActionType.DANGER_SOLID -> {
            this.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.danger_solid_bg))
            this.strokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.danger_solid_bg))
            this.setTextColor(ContextCompat.getColor(context, R.color.danger_solid_color))
        }

        BottomSheetActionType.DANGER_OUTLINED -> {
            this.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.background_body))
            this.strokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.danger_plain_color))
            this.setTextColor(ContextCompat.getColor(context, R.color.danger_plain_color))
        }

        BottomSheetActionType.NEUTRAL -> {
            this.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.background_body))
            this.strokeColor = ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    R.color.neutral_outlined_border
                )
            )
            this.setTextColor(ContextCompat.getColor(context, R.color.neutral_outlined_color))
        }
    }
}