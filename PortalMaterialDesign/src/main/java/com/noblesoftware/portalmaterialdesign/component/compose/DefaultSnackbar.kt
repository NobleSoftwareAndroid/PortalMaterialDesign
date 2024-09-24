package com.noblesoftware.portalmaterialdesign.component.compose

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.noblesoftware.portalmaterialdesign.R
import com.noblesoftware.portalmaterialdesign.model.SnackbarState
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen
import com.noblesoftware.portalmaterialdesign.theme.LocalShapes
import com.noblesoftware.portalmaterialdesign.util.extension.ifNullOrEmpty
import com.noblesoftware.portalmaterialdesign.util.extension.orResourceStringEmpty

/**
 * The DefaultSnackbar composable is used to display a standard snackbar (brief message) with customizable styling. It’s commonly used to inform users about app processes or provide feedback.
 *
 * Parameters
 * @param modifier A modifier that can be used to customize the appearance of the snackbar.
 * @param data A SnackbarData ([SnackbarData]) object containing information about the snackbar content (e.g., title, message, action).
 * @param state A SnackbarState ([SnackbarState]) object that manages the snackbar’s visibility and behavior.
 *
 * @sample
 *
 * @author VPN Android Team
 * @since 2024
 */

@Composable
fun DefaultSnackbar(
    modifier: Modifier = Modifier,
    data: SnackbarData,
    state: SnackbarState,
) {
    val context = LocalContext.current
    val snackbarData = data.visuals.toDefaultSnackBarVisual(context, state)
    val actionLabel = snackbarData.actionLabel
    val contentColor =
        if (snackbarData.isSuccess) colorResource(id = R.color.success_soft_color) else colorResource(
            id = R.color.danger_soft_color
        )
    val containerColor =
        if (snackbarData.isSuccess) colorResource(id = R.color.success_soft_bg) else colorResource(
            id = R.color.danger_soft_bg
        )
    val actionComposable: (@Composable () -> Unit)? = if (actionLabel != null) {
        @Composable {
            TextButton(
                colors = ButtonDefaults.textButtonColors(contentColor = contentColor),
                onClick = { data.performAction() },
                content = {
                    Text(
                        text = actionLabel,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = contentColor
                        )
                    )
                }
            )
        }
    } else {
        null
    }
    val dismissActionComposable: (@Composable () -> Unit)? =
        if (snackbarData.withDismissAction) {
            @Composable {
                IconButton(
                    onClick = { data.dismiss() },
                    content = {
                        Icon(
                            Icons.Filled.Close,
                            contentDescription = "Close",
                            tint = contentColor
                        )
                    }
                )
            }
        } else {
            null
        }
    Box(modifier = modifier.padding(LocalDimen.current.regular)) {
        Snackbar(
            modifier = Modifier
                .clip(LocalShapes.small)
                .shadow(2.dp),
            contentColor = contentColor,
            containerColor = containerColor,
            actionContentColor = contentColor,
            action = actionComposable,
            dismissActionContentColor = contentColor,
            dismissAction = dismissActionComposable,
            shape = LocalShapes.small,
        ) {
            Row {
                Text(
                    text = snackbarData.message,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = contentColor
                    )
                )
            }
        }
    }
}

data class DefaultSnackbarVisuals(
    override val message: String,
    val isSuccess: Boolean,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false
) : SnackbarVisuals

fun SnackbarVisuals.toDefaultSnackBarVisual(context: Context, state: SnackbarState) =
    DefaultSnackbarVisuals(
        message = state.message.ifNullOrEmpty { context.getString(state.messageId.orResourceStringEmpty()) },
        isSuccess = state.isSuccess,
        duration = this.duration,
        actionLabel = this.actionLabel,
        withDismissAction = this.withDismissAction,
    )

suspend fun SnackbarHostState.showDefaultSnackbar(
    context: Context,
    snackbar: SnackbarState,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = SnackbarDuration.Short,
): SnackbarResult {
    return this.showSnackbar(
        DefaultSnackbarVisuals(
            message = snackbar.message.ifNullOrEmpty { context.getString(snackbar.messageId.orResourceStringEmpty()) },
            isSuccess = snackbar.isSuccess,
            actionLabel = actionLabel,
            withDismissAction = withDismissAction,
            duration = duration
        ),
    )
}