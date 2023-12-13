package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import com.example.mascotasapp.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpdateActivity : AppCompatActivity() {

    private lateinit var listaPropietarios: MutableList<Propietarios>

    // Declaramos el binding
    private lateinit var binding : ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActualizar.setOnClickListener(){

            var nombrePropietario = binding.nPropietario.text.toString()
            var direccionPropietario = binding.nuevaDireccion.text.toString()

            // Validaciones
            if (nombrePropietario.isEmpty())
            {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else
            {

                actualizarPropietario(nombrePropietario, direccionPropietario)
                Toast.makeText(this, "Propietario actualizado", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun actualizarPropietario(propietario: String, direccion:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val propietario = MisMascotasApp.database.propietariosDao().obtenerpropietario(propietario)

            if (listaPropietarios.isNotEmpty()) {
                val alumno = listaPropietarios[0]

                // Actualizar la direccion
                propietario.direccion = direccion

                // Actualizar al propietario en la base de datos
                MisMascotasApp.database.propietariosDao().updatePropietario(alumno)
            }
        }
    }
}