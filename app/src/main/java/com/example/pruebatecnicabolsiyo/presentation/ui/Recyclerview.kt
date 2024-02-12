package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.model.Routes
import com.example.pruebatecnicabolsiyo.domain.state.DatabaseState
import com.example.pruebatecnicabolsiyo.presentation.intent.CharacterIntent
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.DatabaseViewModel


@Composable
fun ContentPrincipalView(
    databaseViewModel: DatabaseViewModel,
    apiViewModel: ApiViewModel,
    navController: NavHostController
) {

    val charactersStates by apiViewModel.state.collectAsState()
    val charactersDatabaseStates by databaseViewModel.stateDatabase.collectAsState()

    if (charactersStates.isLoadingApi) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(Modifier.size(50.dp))
        }
    } else if (charactersStates.character != null) {

        for (i in charactersStates.character!!.results.indices)
            databaseViewModel.processIntent(CharacterIntent.SaveDatabase(charactersStates.character!!.results[i]))
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
                    databaseViewModel.processIntent(CharacterIntent.ReadDatabase)
                    if (charactersDatabaseStates.isGetInDatabase)
                        items(charactersDatabaseStates.characterGetDatabase!!.size) { /*index, item ->*/
                            ItemCharacter(
                                charactersDatabaseStates.characterGetDatabase!![it],
                                it,
                                navController,
                                apiViewModel,
                                databaseViewModel,
                                charactersDatabaseStates
                            )
                        }
                })
        }

    } else {
        FetchCharacterButton(apiViewModel)
    }

    LaunchedEffect(false) {
        apiViewModel.processIntent(CharacterIntent.FetchCharacter)
    }
}


@Composable
fun FetchCharacterButton(apiViewModel: ApiViewModel) {
    val charactersStates by apiViewModel.state.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Error: " + charactersStates.error, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = { apiViewModel.processIntent(CharacterIntent.FetchCharacter) }) {
            Text(text = "Volver a cargar")
        }
    }
}

@Composable
fun ItemCharacter(
    charactersAttributes: CharactersFromApiEntity,
    position: Int,
    navController: NavHostController,
    apiViewModel: ApiViewModel,
    databaseViewModel: DatabaseViewModel,
    charactersDatabaseStates: DatabaseState
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
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
                    model = charactersAttributes.image,
                    contentDescription = "photoCharacter",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(modifier = Modifier
                .height(40.dp)
                .width(30.dp)
                .pointerInput(Unit){
                    detectTapGestures(
                        onTap = {
                            databaseViewModel.processIntent(CharacterIntent.FavCharacter(charactersAttributes))
                        }
                    )
                }
                ) {
                if (charactersAttributes.save) {
                    // if (charactersDatabaseStates.isCreateDatabase)
                    //apiViewModel.processIntent(CharacterIntent.ReadDatabase(charactersAttributes))
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "like",
                        tint = Color.Red,
                        modifier = Modifier
                            .height(40.dp)
                            .width(30.dp)

                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "like",
                        tint = Color.White,
                        modifier = Modifier
                            .height(40.dp)
                            .width(30.dp)

                    )
                }

            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = charactersAttributes.name, textAlign = TextAlign.Center
        )
    }
}

