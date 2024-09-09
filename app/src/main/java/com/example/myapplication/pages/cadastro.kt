package com.example.myapplication.pages

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.room.Room
import com.example.myapplication.components.Field
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Cliente

@Composable
fun Cadastrar(appContext: Context){

    val db = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java, "clientes"
    ).allowMainThreadQueries().build()
    
    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var idade = remember { mutableStateOf("") }
    var cpf = remember { mutableStateOf("") }

    Column {
        Field(name = "Nome", text = name)
        Field(name = "Email", text = email)
        Field(name = "Idade", text = idade)
        Field(name = "CPF", text = cpf)

        Button(onClick = {
           var cliente = Cliente(
                uid = 1,
                nome = name.value,
                email = email.value,
                idade = idade.value,
                cpf = cpf.value
            )

            db.clienteDao().insertAll(cliente)
        }) {
            
        }
    }
}