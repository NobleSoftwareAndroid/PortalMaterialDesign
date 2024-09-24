package com.noblesoftware.portalmaterialdesignlibrary.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.noblesoftware.core.ui.component.compose.DefaultEmptyState
import com.noblesoftware.portalmaterialdesign.component.compose.BottomSheetType
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonSize
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonType
import com.noblesoftware.portalmaterialdesign.component.compose.ButtonVariant
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultBottomSheet
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultBottomSheetSessionExpired
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultButton
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultDialog
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultProgressDialog
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultSpacer
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultTextInput
import com.noblesoftware.portalmaterialdesign.component.compose.DefaultTopAppBar
import com.noblesoftware.portalmaterialdesign.theme.LocalDimen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonSampleScreen(
    navHostController: NavHostController
) {
    val text = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val showProgress = remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val bottomSheetState2 = rememberModalBottomSheetState()
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var openBottomSheet2 by rememberSaveable { mutableStateOf(false) }

    Scaffold {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = com.noblesoftware.portalmaterialdesign.R.color.neutral_solid_color))
                .padding(paddingValues = it)
                .verticalScroll(rememberScrollState())
                .then(
                    Modifier.padding(LocalDimen.current.regular)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // button
            Column {
                Text(text = "spacer")
                ExampleDefaultSpacer()

                Text(text = "variant (solid)")
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Solid
                ) {

                }


                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Solid
                ) {

                }

                DefaultSpacer()
                DefaultSpacer()
                ExampleDefaultButton()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Success,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Success,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Solid
                ) {

                }

                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Solid
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Solid
                ) {

                }

                DefaultSpacer(LocalDimen.current.extraLarge)
            }
            Column {
                Text(text = "variant (outlined)")
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Outlined
                ) {

                }


                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Outlined
                ) {

                }

                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Success,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Success,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Success,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Outlined
                ) {

                }

                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Large,
                    buttonType = ButtonType.Outlined
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Warning,
                    buttonSize = ButtonSize.Small,
                    buttonType = ButtonType.Outlined
                ) {

                }

                DefaultSpacer(LocalDimen.current.extraLarge)
            }
            Column {
                Text(text = "variant (solid) icon")
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check In Now",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_in
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check Out Now",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_out
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Help & Support",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_help
                ) {

                }
                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check In Now",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_in
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check Out Now",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_out
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Help & Support",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    startIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_help
                ) {

                }

                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check In Now",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_in
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check Out Now",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_out
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Help & Support",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Solid,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_help
                ) {

                }
                DefaultSpacer()
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check In Now",
                    buttonVariant = ButtonVariant.Primary,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_in
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Check Out Now",
                    buttonVariant = ButtonVariant.Danger,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_check_out
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Help & Support",
                    buttonVariant = ButtonVariant.Neutral,
                    buttonSize = ButtonSize.Medium,
                    buttonType = ButtonType.Outlined,
                    endIcon = com.noblesoftware.portalmaterialdesign.R.drawable.ic_help
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Primary,
                    enabled = false
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Danger,
                    enabled = false
                ) {

                }
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    buttonVariant = ButtonVariant.Neutral,
                    enabled = false
                ) {

                }
                DefaultSpacer(LocalDimen.current.extraLarge)
            }

            // input
            Column {
                Text(text = "input default")
                DefaultSpacer()

                ExampleDefaultTextInput(text)
                DefaultSpacer(LocalDimen.current.regular)
                DefaultTextInput(
                    label = "Password",
                    placeholder = "Please input password",
                    required = true,
                    inputType = KeyboardType.Password,
                    value = text.value,
                    onValueChange = { text.value = it })
                DefaultSpacer(LocalDimen.current.regular)
                Text(text = "input helper")
                DefaultSpacer()

                DefaultTextInput(
                    label = "Email",
                    placeholder = "Please input email",
                    required = true,
                    inputType = KeyboardType.Email,
                    value = text.value,
                    helperText = "Helper text",
                    onValueChange = { text.value = it })
                DefaultSpacer(LocalDimen.current.regular)
                DefaultTextInput(
                    label = "Password",
                    placeholder = "Please input password",
                    required = true,
                    inputType = KeyboardType.Password,
                    value = text.value,
                    helperText = "Password must be at least 8 characters",
                    onValueChange = { text.value = it })
                DefaultSpacer(LocalDimen.current.regular)
                Text(text = "input  error")
                DefaultSpacer()

                DefaultTextInput(
                    label = "Email",
                    placeholder = "Please input email",
                    required = true,
                    inputType = KeyboardType.Email,
                    value = text.value,
                    errorText = "Invalid email or password",
                    onValueChange = { text.value = it })
                DefaultSpacer(LocalDimen.current.regular)
                DefaultTextInput(
                    label = "Password",
                    placeholder = "Please input password",
                    required = true,
                    inputType = KeyboardType.Password,
                    value = text.value,
                    errorText = "Invalid email or password",
                    onValueChange = { text.value = it })

                DefaultSpacer(height = LocalDimen.current.extraLarge)
            }

            // top app bar
            Column {
                Text(text = "top bar default")
                DefaultSpacer()
                DefaultTopAppBar(modifier = Modifier.fillMaxWidth(), title = "Sample Top Bar")
                DefaultSpacer()
                DefaultTopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Sample Top Bar",
                    canBack = true
                )
                DefaultSpacer()
                DefaultTopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Sample Top Bar",
                    canClose = true
                )
                DefaultSpacer()
                ExampleDefaultTopAppBar()
                DefaultSpacer(height = LocalDimen.current.extraLarge)
            }

            // top app bar
            Column {
                Text(text = "progress dialog")
                DefaultSpacer()
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Show Progress",
                    buttonVariant = ButtonVariant.Primary
                ) {
                    showProgress.value = true
                    coroutineScope.launch {
                        delay(3000)
                        showProgress.value = false
                    }
                }
                ExampleProgressDialog(showProgress)
            }

            if (openBottomSheet) {
                DefaultBottomSheetSessionExpired(
                    sheetState = bottomSheetState,
                    onPositive = { openBottomSheet2 = true },
                    onDismissRequest = { openBottomSheet = false }
                )
            }
            if (openBottomSheet2) {
                DefaultBottomSheet(
                    sheetState = bottomSheetState2,
                    bottomSheetType = BottomSheetType.Content,
                    onPositive = { },
                    onDismissRequest = { openBottomSheet2 = false }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = LocalDimen.current.regular),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        // content with column scope
                    }
                }
            }
        }
    }
}

@Composable
private fun ExampleDefaultTopAppBar() {
    DefaultTopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = "Sample Plain Top Bar",
        plain = true,
        canBack = true,
        actions = {
            Row {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = com.noblesoftware.portalmaterialdesign.R.drawable.ic_help),
                        contentDescription = "Help",
                        tint = colorResource(id = com.noblesoftware.portalmaterialdesign.R.color.text_secondary)
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = com.noblesoftware.portalmaterialdesign.R.drawable.ic_profile),
                        contentDescription = "User",
                        tint = colorResource(id = com.noblesoftware.portalmaterialdesign.R.color.text_secondary)
                    )
                }
            }
        }
    )
}

@Composable
private fun ExampleDefaultTextInput(text: MutableState<String>) {
    DefaultTextInput(
        label = "Email",
        placeholder = "Please input email",
        required = true,
        inputType = KeyboardType.Email,
        value = text.value,
        onValueChange = { text.value = it })
}

@Composable
private fun ExampleProgressDialog(showProgress: MutableState<Boolean>) {
    DefaultProgressDialog(show = showProgress.value)
}

@Composable
private fun ExampleDefaultButton() {
    DefaultButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Login",
        buttonVariant = ButtonVariant.Success,
        buttonSize = ButtonSize.Medium,
        buttonType = ButtonType.Solid
    ) {

    }
}

@Composable
private fun ExampleDefaultSpacer() {
    DefaultSpacer(height = 16.dp)
    DefaultSpacer(width = 8.dp)
}

@Composable
private fun ExampleDefaultDialog() {
    DefaultDialog(
        icon = painterResource(id = com.noblesoftware.portalmaterialdesign.R.drawable.img_shield),
        title = "title example",
        message = "message example",
        positiveButtonText = "oke",
        onPositive = { /* positive callback */ },
        onDismissRequest = {/* negative callback */ },
    )
}

@Composable
private fun ExampleEmptyState() {
    DefaultEmptyState(
        modifier = Modifier
            .padding(end = LocalDimen.current.regular)
            .fillMaxWidth(),
        icon = painterResource(id = com.noblesoftware.portalmaterialdesign.R.drawable.img_announcement_empty),
        title = "Coming soon",
        message = "Overview of main features will be shown here"
    )
}