package com.example.android

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.android.databinding.ActivityBaseMainBinding

class BaseMain : BaseActivity()  {

    val binding by lazy { ActivityBaseMainBinding.inflate(layoutInflater) }

    val PERM_CAMERA = arrayOf(android.Manifest.permission.CAMERA)
    val PERM_STORAGE = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

    val REQ_CAMERA = 100
    val REQ_STORAGE = 99

    val TAKE_CAMERA = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 앱이 시작되면 스토리지 권한을 요청
        requestPermissions(PERM_STORAGE, REQ_STORAGE)
        // 카메라 버튼이 눌리면 카메라 권한 요청 후 카메라를 오픈한다.
        binding.btnCamera.setOnClickListener {
            requestPermissions(PERM_CAMERA, REQ_CAMERA)
        }
    }

    override fun permissionGranted(requestCode: Int) {
        when(requestCode) {
            REQ_STORAGE -> Toast.makeText(this,"스토리지 권한이 승인되었습니다.",Toast.LENGTH_SHORT).show()
            REQ_CAMERA -> openCamera()
        }
    }

    override fun permissionDenied(requestCode: Int) {
        when(requestCode) {
            REQ_STORAGE -> {
                Toast.makeText(this,"스토리지 권한이 없으면 앱을 실행할 수 없습니다.",Toast.LENGTH_SHORT).show()
                finish()
            }
            REQ_CAMERA -> Toast.makeText(this,"카메라 권한이 거절되었습니다.",Toast.LENGTH_SHORT).show()
        }
    }

    fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, TAKE_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK) {
            when (requestCode) {
                TAKE_CAMERA -> {
                    // 카메라 촬영 처리
                }
            }
        }
    }
}