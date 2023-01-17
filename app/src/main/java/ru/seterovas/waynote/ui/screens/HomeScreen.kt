package ru.seterovas.waynote.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import ru.seterovas.waynote.ui.nav.NavRoute
import ru.seterovas.waynote.ui.vm.MainViewModel

@Composable
fun HomeScreen(navController: NavController, mViewModel: MainViewModel) {

    val noteListState = mViewModel.noteListFLow.collectAsState(initial = listOf())

    Scaffold(
        floatingActionButton ={
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "AddIcons",
                    tint = Color.White
                )
            }
        }
    ) {
        LazyColumn(content = )
    }
}