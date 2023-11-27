package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.presentation.intent.CharacterIntent
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.ApiViewModel


@Composable
fun NavigationBar(apiViewModel: ApiViewModel) {
    val characterState by apiViewModel.state.collectAsState()
    var enableButtonNext = false
    var enableButtonAfter = false


    with(characterState.character) {
        if (this != null) {
            if (this.info.next != null)
                enableButtonNext = true
            if (this.info.prev != null)
                enableButtonAfter = true
        }
    }

    Box {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            IconButton(
                onClick = {
                    apiViewModel.processIntent(
                        CharacterIntent.NavigateToNextPage(
                            characterState.character?.info?.prev ?: ""
                        )
                    )
                },
                Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color.Cyan),
                enabled = enableButtonAfter
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "icon_previous",
                        tint = Color.Black
                    )
                    Text(
                        text = Constans.PREVIOUS_PAGE, modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            IconButton(
                onClick = {
                    apiViewModel.processIntent(
                        CharacterIntent.NavigateToNextPage(
                            characterState.character?.info?.next ?: ""
                        )
                    )
                },
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Cyan),
                enabled = enableButtonNext
            ) {
                Row {
                    Text(
                        text = Constans.NEXT_PAGE, modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "icon_next",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}