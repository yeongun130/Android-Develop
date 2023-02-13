package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.text.Editable
//import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.android.databinding.ActivityEditTextBinding

class EditText : AppCompatActivity() {

    val binding by lazy { ActivityEditTextBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            editText.addTextChangedListener { editable ->
                //Log.d("EditText","입력된 값${it.toString()}")
                txtHello.text = editable.toString()
            }
        }
    }
}