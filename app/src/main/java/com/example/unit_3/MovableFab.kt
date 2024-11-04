package com.example.unit_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MovableFab : AppCompatActivity() {

    private var dX = 0f
    private var dY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movable_fab)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    dX = motionEvent.rawX - view.x
                    dY = motionEvent.rawY - view.y
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    view.animate()
                        .x(motionEvent.rawX - dX)
                        .y(motionEvent.rawY - dY)
                        .setDuration(0)
                        .start()
                    true
                }
                else -> false
            }
        }
    }
}
