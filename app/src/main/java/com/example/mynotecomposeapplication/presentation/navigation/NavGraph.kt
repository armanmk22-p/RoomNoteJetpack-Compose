package com.example.mynotecomposeapplication.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mynotecomposeapplication.util.Constants.Companion.Note_ID


@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListNoteScreen.route
    ) {
        composable(
            route = Screen.ListNoteScreen.route
        ) {
//            ListNoteScreen(
//                navigateToUpdateNoteScreen = { noteId ->
//                    navController.navigate("${Screen.UpdateNoteScreen.route}/${noteId}")
//                }
//            )
        }
        composable(
            route = "${Screen.UpdateNoteScreen.route}/{$Note_ID}",
            arguments = listOf(
                navArgument(Note_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(Note_ID) ?: 0
//            UpdateNoteScreen(
//                bookId = bookId,
//                navigateBack = {
//                    navController.popBackStack()
//                }
//            )
        }
    }
}