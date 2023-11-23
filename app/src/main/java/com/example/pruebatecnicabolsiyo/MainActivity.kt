package com.example.pruebatecnicabolsiyo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pruebatecnicabolsiyo.core.model.Routes
import com.example.pruebatecnicabolsiyo.presentation.ui.TopAppBarScreen
import com.example.pruebatecnicabolsiyo.presentation.ui.ViewDetailsCharacter
import com.example.pruebatecnicabolsiyo.presentation.ui.theme.PruebaTecnicaBolsiyoTheme
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val apiViewModel by viewModels<ApiViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTecnicaBolsiyoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.Pantalla1.routes) {
                    composable(Routes.Pantalla1.routes) {
                        TopAppBarScreen(apiViewModel = apiViewModel, navController = navController)
                    }
                    composable(
                        Routes.Pantalla2.routes,
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) {backStackEntry ->
                        ViewDetailsCharacter(apiViewModel = apiViewModel, navController,backStackEntry.arguments!!.getInt("id"))
                    }
                }
            }
        }
    }
}

