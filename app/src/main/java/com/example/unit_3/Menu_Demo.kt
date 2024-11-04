package com.example.unit_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Menu_Demo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_demo)
        val fab: FloatingActionButton =findViewById(R.id.fab)
        fab.setOnClickListener{ view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: View){
        val popupMenu = PopupMenu(this,view)
        popupMenu.menuInflater.inflate(R.menu.mymenu,popupMenu.menu)

        val fields = popupMenu.javaClass.declaredFields
        for (field in fields){
            if ("mPopup" == field.name){
                field.isAccessible = true
                val menuPopupHelper = field.get(popupMenu)
                val classPopupHelper = Class.forName(menuPopupHelper.javaClass.name)
                val setForceIcons = classPopupHelper.getMethod("setForceShowIcon", Boolean::class.javaPrimitiveType)
                setForceIcons.invoke(menuPopupHelper,true)
                break
            }
        }

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId)
            {
                R.id.help ->{
                    Toast.makeText(this,"Help",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.logout ->{
                    Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.close ->{
                    Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show()
                    true
                }
                else->false
            }
        }

        popupMenu.show()
    }
}