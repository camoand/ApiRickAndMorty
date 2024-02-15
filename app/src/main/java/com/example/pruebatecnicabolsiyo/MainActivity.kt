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
import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.presentation.ui.TopAppBarScreen
import com.example.pruebatecnicabolsiyo.presentation.ui.ViewDetailsCharacter
import com.example.pruebatecnicabolsiyo.presentation.ui.theme.PruebaTecnicaBolsiyoTheme
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.DatabaseViewModel
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val apiViewModel: ApiViewModel by viewModels()
    private val databaseViewModel: DatabaseViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTecnicaBolsiyoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.Pantalla1.routes) {
                    composable(Routes.Pantalla1.routes) {
                        TopAppBarScreen(
                            databaseViewModel = databaseViewModel,
                            apiViewModel = apiViewModel,
                            navController = navController,
                            searchViewModel = searchViewModel
                        )
                    }
                    composable(
                        Routes.Pantalla2.routes,
                        arguments = listOf(navArgument(Constans.ID) { type = NavType.IntType })
                    ) { backStackEntry ->
                        ViewDetailsCharacter(
                            databaseViewModel = databaseViewModel,
                            apiViewModel = apiViewModel,
                            navController,
                            backStackEntry.arguments?.getInt(Constans.ID) ?: 0
                        )
                    }
                }
            }
        }
    }
}

