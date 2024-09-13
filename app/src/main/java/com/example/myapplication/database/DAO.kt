package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ClienteDao {
    @Query("SELECT * FROM cliente")
    fun getAll(): List<Cliente>

    @Query("SELECT * FROM cliente WHERE uid IN (:clienteIds)")
    fun loadAllByIds(clienteIds: IntArray): List<Cliente>

    @Query("SELECT * FROM cliente WHERE nome LIKE :first")
    fun findByName(first: String): Cliente

    @Insert
    fun insertAll(vararg clientes: Cliente)

    @Update
    fun update(vararg clientes: Cliente)

    @Delete
    fun delete(cliente: Cliente)
}