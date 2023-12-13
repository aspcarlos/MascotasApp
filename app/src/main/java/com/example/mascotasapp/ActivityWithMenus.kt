package com.example.mascotasapp

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import com.example.mascotasapp.databinding.ActivityMainBinding
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import com.example.mascotasapp.databinding.ActivityUpdateBinding

open class ActivityWithMenus: AppCompatActivity() {
    companion object {
        var actividadActual =1;
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //Relacionamos la clase con el layout del menú que hemos creado:
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.anadir_mascota ->  {
                actividadActual = 1
                val intent = Intent(this, ActivityMainBinding::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)

                true
            }

            R.id.eliminar_mascota -> {
                actividadActual= 2
                val intent = Intent(this, ActivityDeleteBinding::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            R.id.actualizar_mascota -> {
                actividadActual= 3
                val intent = Intent(this, ActivityUpdateBinding::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            R.id.mostrar_numero -> {
                actividadActual = 4
                val intent = Intent(this, ActivityMostrarBinding::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}