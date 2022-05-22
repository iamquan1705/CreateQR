package com.example.createqr.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.createqr.databinding.ItemCreateBinding
import com.example.createqr.model.QRITemRecycleView

class QRItemAdapter(private val context: Context) :
    RecyclerView.Adapter<QRItemAdapter.ViewHolder>() {
    private var listModel = arrayListOf<QRITemRecycleView>()


    @SuppressLint("NotifyDataSetChanged")
       fun submit(datas: List<QRITemRecycleView>) {
        listModel.clear()
        listModel.addAll(datas)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCreateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listModel[position])
    }

    override fun getItemCount(): Int = listModel.size


    inner class ViewHolder(private val binding: ItemCreateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(qrmodel: QRITemRecycleView) {
            Glide.with(context).load(qrmodel.image).into(binding.imgItem)
            binding.tvItem.text = qrmodel.type.toString()
        }

    }
}