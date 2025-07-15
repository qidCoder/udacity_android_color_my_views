package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setListeners()
    }

    // onclick listener to change the color of the box on each click
    private fun setListeners() {
        val clickableviews: List<View> = listOf(
            findViewById(R.id.box_one_text),
            findViewById(R.id.box_two_text),
            findViewById(R.id.box_three_text),
            findViewById(R.id.box_four_text),
            findViewById(R.id.box_five_text),
            findViewById(R.id.constraint_layout),
            findViewById(R.id.red_button),
            findViewById(R.id.yellow_button),
            findViewById(R.id.green_button),
        )

        for (view in clickableviews) {
            view.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            // Color class colors
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            // Android color resources
            R.id.box_three_text -> view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light))
            R.id.box_four_text -> view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark))
            R.id.box_five_text -> view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light))

            // using custom colors
            R.id.red_button -> findViewById<View?>(R.id.box_three_text).setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> findViewById<View?>(R.id.box_four_text).setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> findViewById<View?>(R.id.box_five_text).setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}