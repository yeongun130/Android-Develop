package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android.databinding.ActivityAndroidLifeCycleBinding

class AndroidLifeCycle : AppCompatActivity() {

    val binding by lazy { ActivityAndroidLifeCycleBinding.inflate(layoutInflater) }
    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d(TAG, "AndroidLifeCycle - onCreate() called")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "AndroidLifeCycle - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "AndroidLifeCycle - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        with(binding) {
            textView.visibility = View.VISIBLE
            textView.setText("onPause()")
        }
        Log.d(TAG, "AndroidLifeCycle - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "AndroidLifeCycle - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "AndroidLifeCycle - onDestroy() called")
    }
}