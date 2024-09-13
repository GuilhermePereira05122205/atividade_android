package com.example.myapplication.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Cliente

@Composable
fun Listar(db: AppDatabase, navController: NavHostController){

    var clientes = db.clienteDao().getAll()

    LazyColumn {
        items(clientes) {
            clientes ->
            linha(clientes, db, navController)
        }
    }
}

@Composable
fun linha(cliente: Cliente, db: AppDatabase, navController: NavHostController){
    Row {
        Column { Text(cliente.uid.toString()) }
        Column { Text(cliente.nome.orEmpty()) }
        Column { Text(cliente.cpf.orEmpty()) }
        Column { Text(cliente.email.orEmpty()) }
        Column {
            TextButton(
                onClick = { db.clienteDao().delete(cliente) }
            ) {
                Text("Excluir")
            }
        }
        Column {
            TextButton(
                onClick = { navController.navigate( route = "/atualizar/${cliente.nome}") }
            ) {
                Text("Atualizar")
            }
        }
    }
}

