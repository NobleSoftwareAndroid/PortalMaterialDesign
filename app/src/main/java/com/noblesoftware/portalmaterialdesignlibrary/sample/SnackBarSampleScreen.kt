package com.noblesoftware.portalmaterialdesignlibrary.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.noblesoftware.portalmaterialdesign.R
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonType
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonVariant
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultButton
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultSnackbar
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultSpacer
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultTopAppBar
import com.noblesoftware.portalmaterialdesign.component.compose.showDefaultSnackbar
import com.noblesoftware.portalmaterialdesign.model.SnackbarState
import com.noblesoftware.portalmaterialdesign.model.SnackbarType
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen

@Composable
fun SnackBarSampleScreen(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val snackbarState = remember {
        mutableStateOf(
            SnackbarState(
                message = null,
                isSuccess = false
            )
        )
    }
    LaunchedEffect(snackbarState.value) {
        println(snackbarState.value.toString())
        if (!snackbarState.value.message.isNullOrBlank() || snackbarState.value.messageId != null) {
            snackbarHostState.showDefaultSnackbar(
                context = context,
                snackbar = snackbarState.value,
                actionLabel = "OK",
            ).apply {
                when (this) {
                    SnackbarResult.Dismissed -> {
                        snackbarState.value =
                            snackbarState.value.copy(message = null, messageId = null)
                    }

                    SnackbarResult.ActionPerformed -> {
                        snackbarState.value =
                            snackbarState.value.copy(message = null, messageId = null)
                    }
                }
            }
        }
    }

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                modifier = Modifier,
                title = "Snackbar",
                canBack = true,
                navigator = navHostController
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState,
                snackbar = { DefaultSnackbar(data = it, state = snackbarState.value) })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.background_body))
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState())
                .then(
                    Modifier.padding(LocalDimen.current.regular)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Primary",
                buttonVariant = ButtonVariant.Primary
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    type = SnackbarType.Primary,
                )
            }
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Neutral",
                buttonVariant = ButtonVariant.Neutral
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    type = SnackbarType.Neutral,
                )
            }
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Danger",
                buttonVariant = ButtonVariant.Danger
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    type = SnackbarType.Danger,
                )
            }
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Success",
                buttonVariant = ButtonVariant.Success
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    type = SnackbarType.Success,
                )
            }
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Warning",
                buttonVariant = ButtonVariant.Warning
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    type = SnackbarType.Warning,
                )
            }
            DefaultSpacer()
            HorizontalDivider()
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "isSuccess = true",
                buttonVariant = ButtonVariant.Success,
                buttonType = ButtonType.Outlined,
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    isSuccess = true,
                )
            }
            DefaultSpacer()
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "isSuccess = false",
                buttonVariant = ButtonVariant.Danger,
                buttonType = ButtonType.Outlined,
            ) {
                snackbarState.value = SnackbarState(
                    message = "Snackbar message",
                    isSuccess = false,
                )
            }
        }
    }
}