package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pruebatecnicabolsiyo.core.model.Routes
import com.example.pruebatecnicabolsiyo.presentation.intent.CharacterIntent
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel


@Composable
fun ContentPrincipalView(apiViewModel: ApiViewModel, navController: NavHostController) {

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
            LazyVerticalGrid(columns = GridCells.Adaptive(120.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),

                content = {
                    items(charactersStates.character!!.results.size) {
                        ItemCharacter(
                            charactersStates.character!!.results[it].name,
                            charactersStates.character!!.results[it].image,
                            it,
                            navController
                        )
                    }
                })
        }

    } else {
        Text(text = "Error: ${charactersStates.error}")
    }

    LaunchedEffect(false) {
        apiViewModel.processIntent(CharacterIntent.FetchCharacter)
    }
}

@Composable
fun ItemCharacter(name: String, urlImage: String, position: Int, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card(shape = MaterialTheme.shapes.medium, modifier = Modifier
            .clickable {
                navController.navigate(Routes.Pantalla2.createRoute(position)) {
                    popUpTo(
                        Routes.Pantalla2.createRoute(
                            position
                        )
                    ) {
                        inclusive = false
                    }
                }
            }
            .height(200.dp)
            .width(200.dp)) {
            AsyncImage(
                model = urlImage,
                contentDescription = "photoCharacter",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = name, textAlign = TextAlign.Center
        )
    }
}
