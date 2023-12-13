package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MostrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding= ActivityMostrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMostrar.setOnClickListener {
            var propietario_introducido = binding.nPropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                var listaMascotas = MisMascotasApp.database.propietariosDao().mascotasdeunpropietario(propietario_introducido)
                var listamascotas = ""

                listaMascotas.mascotas.forEach {listado ->
                    listamascotas = listamascotas + listado.nombre +"\n"
                }
                binding.numPerros.text = listamascotas
                binding.numGatos.text = listamascotas
            }
        }
    }
}