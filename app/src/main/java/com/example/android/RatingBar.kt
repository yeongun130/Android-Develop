package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityRatingBarBinding

class RatingBar : AppCompatActivity() {

    val binding by lazy { ActivityRatingBarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            ratingbar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if(fromUser) {
                    textView.text = "$rating"
                }
            }
        }
    }
}