package com.example.thrity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.thrity.databinding.ActivityChallengePostBinding

class ChallengePost : AppCompatActivity() {
    private val viewBinding : ActivityChallengePostBinding by lazy {
        ActivityChallengePostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        checkPermission.launch(permissionList)

        viewBinding.btnCamera.setOnClickListener {
            readImage.launch("image/*")
        }

        viewBinding.btnBack.setOnClickListener {
            finish()
        }
    }

    private val permissionList = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
    private val checkPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
        result.forEach {
            if(!it.value) {
                Toast.makeText(applicationContext, "권한 동의 필요", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private val readImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        Glide.with(this)
            .load(uri)
            .into(viewBinding.image)
    }
}