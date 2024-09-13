package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
    data class Cliente(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "nome") val nome: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "idade") val idade: String?,
    @ColumnInfo(name = "cpf") val cpf: String?


)