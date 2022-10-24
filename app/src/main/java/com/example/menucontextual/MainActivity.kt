package com.example.menucontextual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var txt1 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1 = findViewById(R.id.plainTxt)
        registerForContextMenu(txt1) // Se le "asigna" el menú cotextual al txt1
    }

    //Para que aparezca el menú contextual en el txt1
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menucontextual,menu)
    }

    //Capturar acción al dar clic al menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var n = item.itemId
        var texto = txt1.text.toString()
       when(n){
        R.id.itemMayusculas -> { txt1.setText(texto.toUpperCase())}
           else -> {txt1.setText(texto.toLowerCase())}

       }
        return super.onContextItemSelected(item)
    }
}