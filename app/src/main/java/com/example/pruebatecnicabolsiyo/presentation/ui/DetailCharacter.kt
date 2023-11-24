package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pruebatecnicabolsiyo.core.model.Routes
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel

@Composable
fun ViewDetailsCharacter(apiViewModel: ApiViewModel, navController: NavHostController, id: Int) {
    val charactersStates by apiViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close",
            tint = Color.Black,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    navController.navigate(Routes.Pantalla1.routes) {
                        popUpTo(
                            Routes.Pantalla2.routes
                        ) {
                            inclusive = true
                        }
                    }
                }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .height(200.dp)
                .width(160.dp)
        ) {
            AsyncImage(
                model = charactersStates.character!!.results[id].image,
                contentDescription = "photoCharacter",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = charactersStates.character!!.results[id].name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 8.dp)
        ) {
            TextViewDescription(
                atribute = "Origen: ",
                description = charactersStates.character!!.results[id].origin.name
            )
            TextViewDescription(
                atribute = "Especie: ",
                description = charactersStates.character!!.results[id].species
            )
            TextViewDescription(
                atribute = "Genero: ",
                description = charactersStates.character!!.results[id].gender
            )
            TextViewDescription(
                atribute = "tipo: ",
                description = charactersStates.character!!.results[id].type
            )
            TextViewDescription(
                atribute = "locación: ",
                description = charactersStates.character!!.results[id].location.name
            )
            TextViewDescription(
                atribute = "creado: ",
                description = charactersStates.character!!.results[id].created
            )
        }
    }

}

@Composable
fun TextViewDescription(atribute: String, description: String) {
    Spacer(modifier = Modifier.padding(8.dp))
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                )
            ) {
                append(atribute)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                )
            ) {
                append(description)
            }

        }
    )
}