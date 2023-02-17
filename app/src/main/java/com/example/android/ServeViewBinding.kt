package com.example.android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityServeViewBindingBinding

class ServeViewBinding : AppCompatActivity() {

    val binding by lazy { ActivityServeViewBindingBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            txtTo1.text = intent.getStringExtra("from1")
            txtTo2.text = "${intent.getIntExtra("from2", 0)}"

            btnEnd.setOnClickListener {
                val returnintent = Intent()
                val message = editText.text.toString()
                returnintent.putExtra("returnValue",message)
                setResult(Activity.RESULT_OK,returnintent)
                finish()
            }
        }
    }
}