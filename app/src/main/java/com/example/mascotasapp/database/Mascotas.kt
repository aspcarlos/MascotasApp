package com.example.mascotasapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="mascotas")
data class Mascotas(
    @PrimaryKey(autoGenerate = true)
    var nombre:String="",
    var esPerro:Boolean,
    var Raza:String,
    var fecha_nacimiento:String ="",
    var duenio:String=""
)
