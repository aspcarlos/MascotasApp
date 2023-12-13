package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface MascotasDAO {
    @Insert
    fun addMascota(mascota:Mascotas)

    @Delete
    fun eliminar_mascota(mascota:Mascotas)

    @Update
    fun actualizar_mascota(mascota:Mascotas)
}