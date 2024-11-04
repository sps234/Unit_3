package com.example.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class FabDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fab_demo)
        var fab=findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            Snackbar.make(fab,"write ur content",Snackbar.LENGTH_LONG)
                .setAction("Action",null)
                .show()
        }
    }
}