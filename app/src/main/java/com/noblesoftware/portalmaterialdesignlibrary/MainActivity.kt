package com.noblesoftware.portalmaterialdesignlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.noblesoftware.portalmaterialdesign.theme.PortalMaterialDesignTheme
import com.noblesoftware.portalmaterialdesignlibrary.sample.CommonSampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortalMaterialDesignTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = com.noblesoftware.portalmaterialdesign.R.color.background_body)
                ) {
                    CommonSampleScreen(
                        navHostController = rememberNavController()
                    )
                }
            }
        }
    }
}