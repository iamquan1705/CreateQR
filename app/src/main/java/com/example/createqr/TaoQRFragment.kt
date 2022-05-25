package com.example.createqr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.createqr.databinding.FragmentTaoqrBinding


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
            binding.tvResult.text = viewAdd.getResult()
        }

        binding.btnClick.setOnLongClickListener {
            val rotate: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)
            it.startAnimation(rotate)
            return@setOnLongClickListener true
        }
    }


}