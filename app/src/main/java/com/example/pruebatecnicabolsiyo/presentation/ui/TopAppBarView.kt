package com.example.pruebatecnicabolsiyo.presentation.ui

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pruebatecnicabolsiyo.core.model.Routes.*
import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopAppBarScreen(apiViewModel: ApiViewModel, navController: NavHostController) {
    val activity = LocalContext.current as Activity
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), title = { Text(text = Constans.NAME_APP, color = Color.White) }, actions = {
                IconButton(onClick = { activity.finish() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = Color.White
                    )
                }
            })
        }, bottomBar = {

            NavigationBar(apiViewModel = apiViewModel)
        }) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(bottom = 8.dp)
        ) {
            ContentPrincipalView(apiViewModel = apiViewModel, navController)
        }
    }
}