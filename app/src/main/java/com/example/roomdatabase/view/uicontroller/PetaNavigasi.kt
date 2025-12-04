package com.example.roomdatabase.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdatabase.view.DetailSiswaScreen
import com.example.roomdatabase.view.EditSiswaScreen
import com.example.roomdatabase.view.EntrySiswaScreen
import com.example.roomdatabase.view.HomeScreen
import com.example.roomdatabase.view.route.DestinasiDetailSiswa
import com.example.roomdatabase.view.route.DestinasiEditSiswa
import com.example.roomdatabase.view.route.DestinasiEntry
import com.example.roomdatabase.view.route.DestinasiHome

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { id ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$id")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        // 🔹 Detail Siswa
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val idSiswa = backStackEntry.arguments?.getInt(DestinasiDetailSiswa.itemIdArg) ?: 0

            if (idSiswa <= 0) {
                // ID tidak valid → kembali
                navController.navigateUp()
                return@composable
            }

            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEditSiswa.route}/$id")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        // 🔹 Edit Siswa
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val idSiswa = backStackEntry.arguments?.getInt(DestinasiEditSiswa.itemIdArg) ?: 0

            if (idSiswa <= 0) {
                // ID tidak valid → kembali
                navController.navigateUp()
                return@composable
            }

            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}