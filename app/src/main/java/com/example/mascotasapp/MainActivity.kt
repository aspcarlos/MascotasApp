package com.example.mascotasapp

import android.os.Bundle
import android.view.View
import com.example.mascotasapp.database.Mascotas
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.database.MisMascotasApp.Companion.database
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityMainBinding
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {

    // Declaramos el binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            var n_propietario = binding.nombrePropietario.text.toString()
            var d_propietario = binding.direccionPropietario.text.toString()
            var tlf_propietario = binding.telefonoPropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                database.propietariosDao() .anadirPropietario(
                    Propietarios(
                        nombre_propietario = n_propietario,
                        direccion_propietario = d_propietario,
                        tlf_propietario = tlf_propietario,
                    )
                )

            }

            var n_mascota = binding.nombreMascota.text.toString()
            var r_mascota = binding.razaMascota.text.toString()
            var f_n_mascota = binding.fechaNacMascota.text.toString()
            var radio_m = if (binding.radioPerro.isChecked) true else binding.radioGato.isChecked
            CoroutineScope(Dispatchers.IO).launch {
                database.mascotasDao().addMascota(
                    Mascotas(
                        nombre = n_mascota,
                        Raza = r_mascota,
                        fecha_nacimiento = f_n_mascota,
                        esPerro = radio_m
                    )
                )
            }
            // método para ocultar los datos de la mascota
            ocultarDatosMascota()

            runOnUiThread { true }
        }

        binding.btnOtraMascota.setOnClickListener {
            var n_mascota = binding.nombreMascota.text.toString()
            var r_mascota = binding.razaMascota.text.toString()
            var f_n_mascota = binding.fechaNacMascota.text.toString()
            var radio_m = if (binding.radioPerro.isChecked) true else binding.radioGato.isChecked
            CoroutineScope(Dispatchers.IO).launch {
                database.mascotasDao().addMascota(
                    Mascotas(
                        nombre = n_mascota,
                        Raza = r_mascota,
                        fecha_nacimiento = f_n_mascota,
                        esPerro = radio_m
                    )
                )
            }
        }
    }

    private fun ocultarDatosMascota() {
        // ocultar datos de la mascota
        binding.nombreMascota.visibility = View.GONE
        binding.razaMascota.visibility = View.GONE
        binding.fechaNacMascota.visibility = View.GONE
        binding.radioPerro.visibility = View.GONE
        binding.radioGato.visibility = View.GONE
    }
}