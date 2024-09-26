package com.noblesoftware.portalmaterialdesignlibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonVariant
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultButton
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultSpacer
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen

@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = com.noblesoftware.portalmaterialdesign.R.color.background_body))
            .fillMaxSize()
            .padding(
                horizontal = LocalDimen.current.regular,
                vertical = LocalDimen.current.extraLarge
            )
    ) {
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Common Components",
            buttonVariant = ButtonVariant.Neutral
        ) {
            navHostController.navigate(route = Common)
        }
        DefaultSpacer()
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Snackbar",
            buttonVariant = ButtonVariant.Neutral
        ) {
            navHostController.navigate(route = SnackBar)
        }
    }
}