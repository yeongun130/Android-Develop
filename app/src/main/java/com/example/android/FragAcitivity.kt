package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.databinding.ActivityFragAcitivityBinding

class FragAcitivity : AppCompatActivity() {

    val binding by lazy { ActivityFragAcitivityBinding.inflate(layoutInflater) }
    // 1. 사용할 프래그먼트 생성
    val listFragment by lazy { ListFragment() }
    val detailFragment by lazy { DetailFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFramgment()
        binding.btnSend.setOnClickListener {
            listFragment.setValue("값 전달하기")
        }
    }

    fun goDetail() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.framlayout,detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
        onBackPressed()
    }

    fun setFramgment() {

        val bundle = Bundle()
        bundle.putString("key1","Fragment")
        bundle.putInt("key2",20230220)

        listFragment.arguments = bundle

        // 2. 트랜젝션 생성
        val transaction = supportFragmentManager.beginTransaction()
        // 3. 트랜젝션을 통해 프래그먼트 삽입
        transaction.add(R.id.framlayout,listFragment)
        transaction.commit()
    }
}
