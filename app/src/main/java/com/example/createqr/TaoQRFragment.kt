package com.example.createqr

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.createqr.adapter.QRItemAdapter
import com.example.createqr.databinding.FragmentTaoqrBinding
import com.example.createqr.model.QRITemRecycleView
import com.example.createqr.model.TypeQR

class TaoQRFragment : Fragment() {
    private lateinit var binding: FragmentTaoqrBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaoqrBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        var viewAdd = AddView(requireContext())
        binding.llAddView.addView(viewAdd)
        binding.btnClick.setOnClickListener {
            binding.tvResult.text =  viewAdd.getResult()
        }
    }

}