package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityLayoutsTestBinding

class LayoutsTest : AppCompatActivity() {

    val binding by lazy { ActivityLayoutsTestBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}