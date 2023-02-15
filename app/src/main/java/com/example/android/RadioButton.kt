package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android.databinding.ActivityRadioButtonBinding

class RadioButton : AppCompatActivity() {

    val binding by lazy { ActivityRadioButtonBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radio_apple ->  Log.d("라디오버튼","사과가 선택되었습니다.")
                R.id.radio_banana -> Log.d("라디오버튼","바나나가 선택되었습니다.")
                R.id.radio_orange -> Log.d("라디오버튼","오렌지가 선택되었습니다.")
            }
        }
    }
}