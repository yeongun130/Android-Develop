package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.databinding.ActivityProgressBarBinding
import kotlin.concurrent.thread

class ProgressBar : AppCompatActivity() {

    val binding by lazy { ActivityProgressBarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            txtSuccess.visibility = View.INVISIBLE
            btn.setOnClickListener {
                btn.visibility = View.GONE
                showProgress(true)
            }
            thread(start = true) {
                txtSuccess.visibility = View.INVISIBLE
                Thread.sleep(3000)
                runOnUiThread {
                    showProgress(false)
                    txtSuccess.visibility = View.VISIBLE
                }
            }
        }
    }

    fun showProgress(show:Boolean) {
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }
}