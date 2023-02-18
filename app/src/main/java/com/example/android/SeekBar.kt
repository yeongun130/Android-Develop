package com.example.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.android.databinding.ActivitySeekbarBinding

class SeekBar : AppCompatActivity() {

    val binding by lazy { ActivitySeekbarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    if(p2) { // 사람이 터치로 동작 시킬 때만 코드 실행
                        txtZero.text = "$p1％"
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}
            })
        }
    }
}
