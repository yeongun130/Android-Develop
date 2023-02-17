package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toast
import com.example.android.databinding.ActivityMainViewBindingBinding

class MainViewBinding : AppCompatActivity() {

    val binding by lazy { ActivityMainViewBindingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, ServeViewBinding::class.java)
            intent.putExtra("from1","Hello Bundle")
            intent.putExtra("from2",2023)
            //startActivityForResult(intent,99)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(resultCode == RESULT_OK) {
//            when(requestCode) {
//                99 -> {
//                    data?.getStringExtra("returnValue").let { message ->
//                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//    }
}