package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.android.databinding.ActivityCheckBoxBinding

class CheckBox : AppCompatActivity() {

    val binding by lazy { ActivityCheckBoxBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            checkApple.setOnCheckedChangeListener(listener)
            checkBanana.setOnCheckedChangeListener(listener)
            checkOragne.setOnCheckedChangeListener(listener)
        }
    }
    val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

        when(buttonView.id) {
            R.id.check_apple -> {
                if (isChecked) Log.d("체크박스", "사과가 선택되었습니다.")
                else Log.d("체크박스", "사과가 선택 해제되었습니다.")
            }
            R.id.check_banana -> {
                if (isChecked) Log.d("체크박스", "바나나가 선택되었습니다.")
                else Log.d("체크박스", "바나나가 선택 해제되었습니다.")
            }
            R.id.check_oragne -> {
                if (isChecked) Log.d("체크박스", "오렌지가 선택되었습니다.")
                else Log.d("체크박스", "오렌지가 선택 해제되었습니다.")
            }
        }
    }
}