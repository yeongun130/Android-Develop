package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.android.databinding.ActivitySpinnerBinding

class Spinner : AppCompatActivity() {

    val binding by lazy { ActivitySpinnerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = listOf("선택하세요","1월","2월","3월")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        with(binding) {
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val selected = data.get(p2)
                    result.text = selected
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        }
    }
}