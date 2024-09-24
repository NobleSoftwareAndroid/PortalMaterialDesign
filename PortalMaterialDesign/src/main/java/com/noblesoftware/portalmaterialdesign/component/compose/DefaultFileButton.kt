package com.noblesoftware.portalmaterialdesign.component.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.noblesoftware.portalmaterialdesign.R
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen
import com.noblesoftware.portalmaterialdesign.theme.LocalShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultFileButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = colorResource(id = R.color.primary_plain_color),
    @DrawableRes icon: Int = R.drawable.ic_paperclip,
    iconTint: Color = colorResource(id = R.color.primary_plain_color),
    iconBackgroundColor: Color = colorResource(id = R.color.primary_plain_active_bg),
    backgroundColor: Color = colorResource(id = R.color.background_body),
    borderColor: Color = colorResource(id = R.color.divider),
    rippleColor: Color = colorResource(id = R.color.primary_plain_color),
    buttonType: ButtonType = ButtonType.Outlined,
    onClick: () -> Unit,
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        Button(
            modifier = modifier,
            contentPadding = PaddingValues(LocalDimen.current.zero),
            shape = LocalShapes.medium,
            border = BorderStroke(
                width = 1.dp,
                color = if (buttonType == ButtonType.Outlined) borderColor else backgroundColor,
            ),
            colors = ButtonColors(
                containerColor = backgroundColor,
                contentColor = rippleColor,
                disabledContainerColor = colorResource(id = R.color.primary_solid_disabled_bg),
                disabledContentColor = colorResource(id = R.color.primary_solid_disabled_color)
            ),
            onClick = onClick,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = LocalDimen.current.small,
                        top = LocalDimen.current.small,
                        end = LocalDimen.current.default,
                        bottom = LocalDimen.current.small,
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(LocalDimen.current.small))
                        .background(iconBackgroundColor)
                        .padding(LocalDimen.current.small)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        tint = iconTint,
                        contentDescription = ""
                    )
                }
                DefaultSpacer(width = LocalDimen.current.default)
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = textColor
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}