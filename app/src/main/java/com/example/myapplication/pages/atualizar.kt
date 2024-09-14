package com.example.myapplication.pages

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.myapplication.components.Field
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Cliente
import kotlin.math.log

@Composable
fun Atualizar(db: AppDatabase, navController: NavHostController, nome: String?){

    var cliente = db.clienteDao().findByName(nome.orEmpty())

    var name = remember { mutableStateOf(cliente.nome.orEmpty()) }
    var email = remember { mutableStateOf(cliente.email.orEmpty()) }
    var idade = remember { mutableStateOf(cliente.idade.orEmpty()) }
    var cpf = remember { mutableStateOf(cliente.cpf.orEmpty()) }

    Column {
        Field("name", name)
        Field("email", email)
        Field("idade", idade)
        Field("CPF", cpf)
        Button(onClick = {

            var cliente2 = Cliente(
                uid = cliente.uid,
                nome = name.value,
                email = email.value,
                idade = idade.value,
                cpf = cpf.value
            )

            db.clienteDao().update(cliente2)

        }) { Text("atualizar") }
        Button(onClick = { navController.navigate(route = "/listar")}) {
            Text("listar")
        }
    }
}