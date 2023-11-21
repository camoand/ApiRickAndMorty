package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel


@Composable
fun PrincipalView(apiViewModel: ApiViewModel) {

    val charactersStates by apiViewModel.state.collectAsState()
    Column( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (charactersStates.isLoading) {
            CircularProgressIndicator()
        } else if (charactersStates.character != null) {
            LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                items(charactersStates.character!!.results.size) {
                    ItemCharacter(charactersStates.character!!.results[it].name,charactersStates.character!!.results[it].image,it)
                }
            })
        }else {
            Text(text = "Error: ${charactersStates.error}")
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { apiViewModel.fetchCharacter() },) {
            Text(text = "Fetch Character")
        }
    }



}


@Composable
fun ItemCharacter(name:String,urlImage: String, position :Int) {

    val painter: ImagePainter =  rememberImagePainter(data = urlImage)

    Card(border = BorderStroke(1.dp, Color.Cyan), modifier = Modifier
        .width(200.dp)
        .clickable { }) {
        Column {
            Image(painter = painter, contentDescription = "photoCharacter" )
            Text(
                text = name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}