package com.example.pruebatecnicabolsiyo.presentation.ui

import android.annotation.SuppressLint
import android.content.ContextParams
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopAppBarScreen(apiViewModel: ApiViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(/*colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),*/ title = { Text(text = "Api Rick and Morty") }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                }
            })
        }) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            PrincipalView(apiViewModel = apiViewModel)
        }
    }
}

@Composable
fun PrincipalView(apiViewModel: ApiViewModel) {

    val charactersStates by apiViewModel.state.collectAsState()

    if (charactersStates.isLoading) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(Modifier.size(50.dp))
        }
    } else if (charactersStates.character != null) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(charactersStates.character!!.results.size) {
                        ItemCharacter(
                            charactersStates.character!!.results[it].name,
                            charactersStates.character!!.results[it].image,
                            it
                        )
                    }
                })
        }

    } else {
        Text(text = "Error: ${charactersStates.error}")
    }

    // Spacer(modifier = Modifier.padding(8.dp))
    apiViewModel.fetchCharacter()
    /*   Button(onClick = { apiViewModel.fetchCharacter() }) {
           Text(text = "Fetch Character")
       }*/

}

@Composable
fun ItemCharacter(name: String, urlImage: String, position: Int) {

    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .clickable { }) {
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            AsyncImage(
                model = urlImage,
                contentDescription = "photoCharacter",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = name,
                textAlign = TextAlign.Center
            )
        }

    }
}