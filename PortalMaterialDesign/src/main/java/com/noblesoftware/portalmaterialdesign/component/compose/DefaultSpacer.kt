package com.noblesoftware.portalmaterialdesign.component.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen

/**
 * The DefaultSpacer composable is used to insert empty space (padding) between UI elements. It allows you to control the vertical and horizontal spacing within your layout.
 *
 * Parameters
 * @param height The vertical spacing (height) to add. Defaults to the regular spacing defined by the current theme.
 * @param width The horizontal spacing (width) to add. Defaults to the regular spacing defined by the current theme.
 *
 * @sample DefaultSpacer
 *
 * @author VPN Android Team
 * @since 2024
 */
@Composable
fun DefaultSpacer(
    height: Dp = LocalDimen.current.regular,
    width: Dp = LocalDimen.current.regular,
) {
    Spacer(
        modifier = Modifier
            .height(height)
            .width(width)
    )
}