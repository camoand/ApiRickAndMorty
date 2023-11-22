package com.example.pruebatecnicabolsiyo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.pruebatecnicabolsiyo.presentation.ui.PrincipalView
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
                // A surface container using the 'background' color from the theme
                    TopAppBarScreen(apiViewModel = apiViewModel)
                  //  PrincipalView(apiViewModel = apiViewModel)

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaTecnicaBolsiyoTheme {
        Greeting("Android")
    }
}