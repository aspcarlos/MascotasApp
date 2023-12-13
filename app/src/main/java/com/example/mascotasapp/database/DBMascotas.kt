package com.example.mascotasapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Mascotas::class, Propietarios::class],
    version = 1)

abstract class DBMascotas() {
    abstract fun propietariosDao(): PropietariosDAO
    abstract fun mascotasDao(): MascotasDAO
}
