package com.noblesoftware.portalmaterialdesignlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noblesoftware.portalmaterialdesign.theme.PortalMaterialDesignTheme
import com.noblesoftware.portalmaterialdesignlibrary.sample.CommonSampleScreen
import com.noblesoftware.portalmaterialdesignlibrary.sample.SnackBarSampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortalMaterialDesignTheme {
                val navController = rememberNavController()
                Scaffold {
                    NavHost(navController, startDestination = Main, Modifier.padding(it)) {
                        composable<Main> { MainScreen(navHostController = navController) }
                        composable<Common> { CommonSampleScreen(navHostController = navController) }
                        composable<SnackBar> { SnackBarSampleScreen(navHostController = navController) }
                    }
                }
            }
        }
    }
}