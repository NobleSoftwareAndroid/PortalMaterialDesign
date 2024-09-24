package com.noblesoftware.portalmaterialdesign.component.xml.options_bottom_sheet

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.colorResource
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.noblesoftware.portalmaterialdesign.R
import com.noblesoftware.portalmaterialdesign.databinding.BottomSheetDialogBinding
import com.noblesoftware.portalmaterialdesign.enums.BottomSheetType
import com.noblesoftware.portalmaterialdesign.model.SelectOption
import com.noblesoftware.portalmaterialdesign.theme.PortalMaterialDesignTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class DefaultBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogBinding
    private val viewModel: BottomSheetViewModel by viewModels()

    private var bottomSheetType = BottomSheetType.SINGLE_SELECTION
    private var searchHint = ""
    private var options: List<SelectOption> = listOf()
    private var onSelected: (List<SelectOption>) -> Unit = {}
    private var onDismiss: () -> Unit = {}

    override fun getTheme(): Int = R.style.ModalBottomSheetDialog

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.bottom_sheet_dialog,
                container,
                false
            )
        binding.lifecycleOwner = viewLifecycleOwner
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val onEvent = viewModel::onEvent
                val state = viewModel.state.collectAsState().value

                PortalMaterialDesignTheme(window = requireActivity().window) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .nestedScroll(rememberNestedScrollInteropConnection()),
                        color = colorResource(id = R.color.background_body)
                    ) {
                        Column(
                            modifier = Modifier.then(
                                if (bottomSheetType == BottomSheetType.SINGLE_SELECTION_WITH_SEARCH ||
                                    bottomSheetType == BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH
                                ) {
                                    Modifier.fillMaxSize()
                                } else {
                                    Modifier.fillMaxWidth()
                                }
                            )
                        ) {
//                            DefaultSpacer(height = LocalDimen.current.medium)
//                            if (bottomSheetType == BottomSheetType.SINGLE_SELECTION_WITH_SEARCH ||
//                                bottomSheetType == BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH
//                            ) {
//                                DefaultTextInput(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(horizontal = LocalDimen.current.regular),
//                                    value = state.keywords,
//                                    leadingIcon = {
//                                        DefaultTextInputIcon(
//                                            modifier = Modifier,
//                                            icon = painterResource(id = R.drawable.ic_search),
//                                        )
//                                    },
//                                    trailingIcon = if (state.keywords.isNotBlank()) {
//                                        {
//                                            IconButton(onClick = {
//                                                onEvent(BottomSheetEvent.OnSearch(""))
//                                            }) {
//                                                Icon(
//                                                    painter = painterResource(id = R.drawable.ic_close),
//                                                    tint = colorResource(id = R.color.text_icon),
//                                                    contentDescription = ""
//                                                )
//                                            }
//                                        }
//                                    } else {
//                                        null
//                                    },
//                                    placeholder = searchHint,
//                                    onValueChange = {
//                                        onEvent(BottomSheetEvent.OnSearch(it))
//                                    },
//                                )
//                                DefaultSpacer(height = LocalDimen.current.regular)
//                            }
//                            LazyColumn(
//                                modifier = Modifier.fillMaxWidth(),
//                                contentPadding = PaddingValues(
//                                    start = LocalDimen.current.regular,
//                                    end = LocalDimen.current.regular,
//                                    bottom = if (bottomSheetType == BottomSheetType.MULTIPLE_SELECTION || bottomSheetType == BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH) 180.dp else LocalDimen.current.extraLarge
//                                ),
//                                verticalArrangement = Arrangement.spacedBy(
//                                    if (bottomSheetType == BottomSheetType.SINGLE_SELECTION_WITH_SEARCH ||
//                                        bottomSheetType == BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH
//                                    ) LocalDimen.current.small else LocalDimen.current.zero
//                                )
//                            ) {
//                                items(if (state.keywords.isEmpty()) state.selectOptions.size else state.filteredSelectOptions.size) {
//                                    val selectOption =
//                                        if (state.keywords.isEmpty()) state.selectOptions[it] else state.filteredSelectOptions[it]
//                                    if (bottomSheetType != BottomSheetType.MULTIPLE_SELECTION && bottomSheetType != BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH) {
//                                        Box(
//                                            modifier = Modifier
//                                                .clip(RoundedCornerShape(LocalDimen.current.small))
//                                                .fillMaxWidth()
//                                                .then(
//                                                    if (selectOption.isSelected) {
//                                                        Modifier.background(color = colorResource(id = R.color.primary_plain_active_bg))
//                                                    } else {
//                                                        Modifier
//                                                    }
//                                                )
//                                                .then(
//                                                    if (selectOption.enabled) {
//                                                        Modifier.clickable(
//                                                            interactionSource = remember { MutableInteractionSource() },
//                                                            indication = rememberRipple(
//                                                                color = colorResource(id = R.color.primary_plain_color),
//                                                            ),
//                                                            onClick = {
//                                                                onSelected.invoke(
//                                                                    arrayListOf(
//                                                                        selectOption
//                                                                    )
//                                                                )
//                                                                dismiss()
//                                                            },
//                                                        )
//                                                    } else Modifier
//                                                )
//                                                .padding(
//                                                    horizontal = LocalDimen.current.default,
//                                                    vertical = LocalDimen.current.regular
//                                                )
//                                        ) {
//                                            Text(
//                                                text = if (selectOption.nameId != null) stringResource(
//                                                    id = selectOption.nameId
//                                                        ?: R.string.empty_string
//                                                ) else selectOption.name,
//                                                style = MaterialTheme.typography.bodyMedium.copy(
//                                                    color = colorResource(id = if (selectOption.isSelected) R.color.primary_plain_color else if (selectOption.enabled.isFalse()) R.color.primary_plain_disabled_color else R.color.text_primary)
//                                                )
//                                            )
//                                        }
//                                    } else {
//                                        Row(
//                                            modifier = Modifier
//                                                .clip(RoundedCornerShape(LocalDimen.current.small))
//                                                .fillMaxWidth()
//                                                .then(
//                                                    if (selectOption.isSelected) {
//                                                        Modifier.background(color = colorResource(id = R.color.primary_plain_active_bg))
//                                                    } else {
//                                                        Modifier
//                                                    }
//                                                )
//                                                .clickable(
//                                                    interactionSource = remember { MutableInteractionSource() },
//                                                    indication = rememberRipple(
//                                                        color = colorResource(id = R.color.primary_plain_color),
//                                                    ),
//                                                    onClick = {
//                                                        onEvent(
//                                                            BottomSheetEvent.OnSelect(
//                                                                selectOption
//                                                            )
//                                                        )
//                                                    },
//                                                )
//                                                .padding(
//                                                    horizontal = LocalDimen.current.default,
//                                                    vertical = LocalDimen.current.regular
//                                                ),
//                                            verticalAlignment = Alignment.CenterVertically,
//                                        ) {
//                                            CompositionLocalProvider(
//                                                LocalMinimumInteractiveComponentEnforcement provides false
//                                            ) {
//                                                Checkbox(
//                                                    checked = selectOption.isSelected,
//                                                    onCheckedChange = {
//                                                        onEvent(
//                                                            BottomSheetEvent.OnSelect(
//                                                                selectOption
//                                                            )
//                                                        )
//                                                    })
//                                            }
//                                            DefaultSpacer(width = 14.dp)
//                                            Text(
//                                                text = if (selectOption.nameId != null) stringResource(
//                                                    id = selectOption.nameId
//                                                        ?: R.string.empty_string
//                                                ) else selectOption.name,
//                                                style = MaterialTheme.typography.bodyMedium.copy(
//                                                    color = colorResource(id = if (selectOption.isSelected) R.color.primary_plain_color else R.color.text_primary)
//                                                )
//                                            )
//                                        }
//                                    }
//                                }
//                            }
                        }
                    }
                }
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEvent(BottomSheetEvent.InitSelectOptions(options))
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if (bottomSheetType != BottomSheetType.MULTIPLE_SELECTION && bottomSheetType != BottomSheetType.MULTIPLE_SELECTION_WITH_SEARCH) {
            return super.onCreateDialog(savedInstanceState)
        }

        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            (it as BottomSheetDialog).findViewById<CoordinatorLayout>(com.google.android.material.R.id.coordinator)

            val containerLayout =
                it.findViewById<FrameLayout>(com.google.android.material.R.id.container)

            val buttons = bottomSheetDialog.layoutInflater.inflate(
                R.layout.button_select_option_dialog,
                null
            )
            val buttonSave = buttons.findViewById<MaterialButton>(R.id.btn_save)
            val buttonCancel = buttons.findViewById<MaterialButton>(R.id.btn_cancel)

            buttonSave.setOnClickListener {
                onSelected.invoke(viewModel.state.value.selectOptions.filter { option ->
                    option.isSelected
                })
                dismiss()
            }
            buttonCancel.setOnClickListener {
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

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss.invoke()
    }

    companion object {
        fun showDialog(
            fragmentManager: FragmentManager,
            bottomSheetType: BottomSheetType,
            searchHint: String = "",
            options: List<SelectOption> = listOf(),
            onDismiss: () -> Unit = {},
            onSelected: (List<SelectOption>) -> Unit = {}
        ) {
            DefaultBottomSheetDialog().apply {
                this.bottomSheetType = bottomSheetType
                this.searchHint = searchHint
                this.options = options
                this.onDismiss = onDismiss
                this.onSelected = onSelected
            }.show(fragmentManager, DefaultBottomSheetDialog::class.java.simpleName)
        }
    }
}

