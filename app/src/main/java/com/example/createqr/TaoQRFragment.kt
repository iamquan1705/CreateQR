package com.example.createqr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
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
        var adapter = QRItemAdapter(requireContext())
        adapter.submit(listQRMODEL)
        binding.rcQrCode.adapter = adapter
        binding.rcQrCode.layoutManager = GridLayoutManager(requireContext(), 3)

    }

    private var listQRMODEL = arrayListOf<QRITemRecycleView>(
        QRITemRecycleView(TypeQR.PHONE, R.drawable.message_text),
        QRITemRecycleView(TypeQR.EMAIL, R.drawable.color),
        QRITemRecycleView(TypeQR.URL, R.drawable.message_text),
        QRITemRecycleView(TypeQR.SMS, R.drawable.color),
        QRITemRecycleView(TypeQR.CONTACT, R.drawable.message_text),
        QRITemRecycleView(TypeQR.TEXT, R.drawable.color),
        QRITemRecycleView(TypeQR.WIFI, R.drawable.message_text),
        QRITemRecycleView(TypeQR.CALENDER, R.drawable.color),
        QRITemRecycleView(TypeQR.LOCATION, R.drawable.message_text),
    )

}