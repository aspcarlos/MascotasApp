package com.example.mascotasapp.database

import androidx.room.Embedded
import androidx.room.Relation

data class PropietarioConMascotas(
    @Embedded
    val propietarios: Propietarios,

    @Relation(
        parentColumn = "nombre_propietario",
        entityColumn = "propietario_mascota"
    )
    val mascotas: List<Mascotas>
)
