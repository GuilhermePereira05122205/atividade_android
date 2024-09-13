package com.example.myapplication.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.myapplication.components.Field
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Cliente

@Composable
fun Atualizar(db: AppDatabase, nome: String?){

    var cliente = db.clienteDao().findByName(nome.orEmpty())

    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var idade = remember { mutableStateOf("") }
    var cpf = remember { mutableStateOf("") }

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
    }
}