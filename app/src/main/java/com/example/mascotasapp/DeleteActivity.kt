package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp.Companion.database
import com.example.mascotasapp.database.Propietarios
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DeleteActivity : AppCompatActivity() {

    private lateinit var listaPropietarios: MutableList<Propietarios>

    // Declaramos el binding
    private lateinit var binding : ActivityDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btonEliminar.setOnClickListener {
            // n_propietario contiene el nombre del propietario introducido
            val n_propietario = binding.escribePropietario.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                //listaLibros contiene el listado de libros de un autor
                var listaMascotas = database.propietariosDao().mascotasdeunpropietario(n_propietario)

                // vamos eliminando mascota por mascota:
                for (mascota in listaMascotas.mascotas) {
                    database.mascotasDao().eliminar_mascota(mascota)
                }

                // obtenemos el registro del propietario
                var pro = database.propietariosDao().obtenerpropietario(n_propietario)

                database.propietariosDao().eliminar_propietario(pro)
            }

        }
    }
}