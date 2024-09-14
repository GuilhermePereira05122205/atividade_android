package com.example.myapplication.pages

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.components.Field
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Cliente

@Composable
fun Cadastrar(db: AppDatabase, navController: NavHostController){

    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var idade = remember { mutableStateOf("") }
    var cpf = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Field(name = "Nome", text = name)
        Field(name = "Email", text = email)
        Field(name = "Idade", text = idade)
        Field(name = "CPF", text = cpf)

        Button(onClick = {
           var cliente = Cliente(
                uid = null,
                nome = name.value,
                email = email.value,
                idade = idade.value,
                cpf = cpf.value
            )

            db.clienteDao().insertAll(cliente)
        }) {
            Text("Cadastrar")
        }
        
        Button(onClick = { navController.navigate(route = "/listar")}) {
            Text("listar")
        }
    }


}