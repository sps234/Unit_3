package com.example.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabDemo1 : AppCompatActivity() {
    lateinit var addFAB: FloatingActionButton
    lateinit var homeFAB: FloatingActionButton
     lateinit var SettingsFAB:FloatingActionButton
     var fabVisible =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fab_demo1)


        addFAB =findViewById(R.id.idFABAdd)
        homeFAB=findViewById(R.id.idFABHome)
        SettingsFAB=findViewById(R.id.idFABSettings)

          fabVisible=false

        addFAB.setOnClickListener {
            addFAB.visibility = View.GONE
            SettingsFAB.visibility = View.VISIBLE
            homeFAB.visibility = View.VISIBLE
}
    }
}