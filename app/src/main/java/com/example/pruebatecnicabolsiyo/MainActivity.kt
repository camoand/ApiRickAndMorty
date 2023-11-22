package com.example.pruebatecnicabolsiyo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pruebatecnicabolsiyo.presentation.ui.TopAppBarScreen
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
                    TopAppBarScreen(apiViewModel = apiViewModel)
            }
        }
    }
}

