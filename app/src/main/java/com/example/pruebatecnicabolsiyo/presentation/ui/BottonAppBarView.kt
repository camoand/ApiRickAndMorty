package com.example.pruebatecnicabolsiyo.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.pruebatecnicabolsiyo.presentation.viewmodel.DatabaseViewModel


@Composable
fun NavigationBar(databaseViewModel: DatabaseViewModel, apiViewModel: ApiViewModel) {
    val characterState by apiViewModel.state.collectAsState()
    val charactersDatabaseStates by databaseViewModel.stateDatabase.collectAsState()

    /*    var enableButtonNext = false
        var enableButtonAfter = false*/


    /* with(characterState.character) {
         if (this != null) {
             if (this.info.next != null)
                 enableButtonNext = true
             if (this.info.prev != null)
                 enableButtonAfter = true
         }
     }*/

    Box {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            IconButton(
                onClick = {
                    if (!charactersDatabaseStates.isGetInDatabaseFavorite)
                        databaseViewModel.processIntent(CharacterIntent.ReadDatabaseFavotite)
                    else
                        databaseViewModel.processIntent(CharacterIntent.ReadDatabase)

                },
                Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Color.Cyan),
                //  enabled = enableButtonAfter
            ) {
                if (!charactersDatabaseStates.isGetInDatabaseFavorite) {
                    Text(
                        text = Constans.FAVORITE, modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                } else
                    Text(
                        text = Constans.ALL_CHARACTERS, modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
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
                    .background(Color.Cyan)
            ) {
                Row {
                    Text(
                        text = Constans.LOADING_MORE, modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}