package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class Listener : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

          val button = findViewById<Button>(R.id.button)
//        val listener = object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//
//            }
//        }

        button.setOnClickListener {
            Log.d("listener","클릭되었습니다.")
        }
    }
}
