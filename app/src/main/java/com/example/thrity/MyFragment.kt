package com.example.thrity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thrity.databinding.FragmentExploreBinding
import com.example.thrity.databinding.FragmentMyBinding

class MyFragment: Fragment() {
    private lateinit var viewBinding: FragmentMyBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMyBinding.inflate(layoutInflater)

        viewBinding.btnMySetting.setOnClickListener {
            val intent = Intent(context, Setting::class.java)
            startActivity(intent)
        }

        viewBinding.tvNotice.setOnClickListener {
            val intent = Intent(context, Notice::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}