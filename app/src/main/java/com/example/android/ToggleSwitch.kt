package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityToggleSwitchBinding

class ToggleSwitch : AppCompatActivity() {

    val binding by lazy { ActivityToggleSwitchBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnToggle.setOnCheckedChangeListener { buttonView, isChecked ->
                txtToggle.text = if(isChecked) "On" else "Off"
            }
            btnSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                txtSwitch.text = if(isChecked) "On" else "Off"
            }
        }
    }
}