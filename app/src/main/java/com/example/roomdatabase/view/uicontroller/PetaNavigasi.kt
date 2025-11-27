package com.example.roomdatabase.view.uicontroller

import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdatabase.view.route.DestinasiEntry
import com.example.roomdatabase.view.route.DestinasiHome
import com.example.roomdatabase.view.EntrySiswaScreen
import com.example.roomdatabase.view.HomeScreen

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}