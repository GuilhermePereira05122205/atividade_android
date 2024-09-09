package com.example.myapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Field(name: String, text: MutableState<String>){
    Column {
        Text(text = name)
        TextField(value = text.value, onValueChange = {text.value = it})
    }
}