package ru.seterovas.waynote.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.seterovas.waynote.ui.screens.AddScreen
import ru.seterovas.waynote.ui.screens.DetailScreen
import ru.seterovas.waynote.ui.screens.HomeScreen
import ru.seterovas.waynote.ui.vm.MainViewModel
import ru.seterovas.waynote.util.Constants

sealed class NavRoute(val route: String){
    object Home: NavRoute(route = Constants.Screens.HOME)
    object Add: NavRoute(route = Constants.Screens.ADD)
    object Detail: NavRoute(route = Constants.Screens.DETAIL)
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Home.route){
        composable(route = NavRoute.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = NavRoute.Home.route){
            AddScreen(navController = navController)
        }
        composable(route = NavRoute.Home.route){
            DetailScreen(navController = navController)
        }
    }
}