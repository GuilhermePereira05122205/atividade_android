package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.pages.Atualizar
import com.example.myapplication.pages.Cadastrar


@Composable
fun Navigation(navController: NavHostController, db: AppDatabase){
    NavHost(navController = navController, startDestination = "/"){
        composable(
            route = "/"
        ) { Cadastrar(db) }
        composable(
            route = "/atualizar/{name}",
            arguments =  listOf(navArgument("name"){type = NavType.StringType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("name")
            Atualizar(db, id)
        }
    }

}