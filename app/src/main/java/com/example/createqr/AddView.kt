package com.example.createqr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import com.example.createqr.databinding.ViewAddBinding

class AddView(context: Context) : LinearLayout(context) {
    private var binding: ViewAddBinding =
        ViewAddBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        initView()
    }

    private fun initView() {
        initRadioButton()
    }

    private var result = ""
    private var number: Int = 0
    fun getResult(): String {
        if (binding.rb1.isChecked) {
            number = 1
        } else if (binding.rb2.isChecked) {
            number = 2
        } else {
            number = 3
        }
        result = "$number" + binding.btn1.text.toString() + binding.btn2.text.toString()
        return result
    }

    private fun initRadioButton() {
        binding.rGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkId ->
            run {
                if (binding.rb1.isChecked) {
                    binding.rb1.setTextColor(resources.getColor(R.color.color_true))
                    binding.rb2.setTextColor(resources.getColor(R.color.color_false))
                    binding.rb3.setTextColor(resources.getColor(R.color.color_false))
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.GONE

                } else if (binding.rb2.isChecked) {
                    binding.rb2.setTextColor(resources.getColor(R.color.color_true))
                    binding.rb1.setTextColor(resources.getColor(R.color.color_false))
                    binding.rb3.setTextColor(resources.getColor(R.color.color_false))
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE

                } else {
                    binding.rb3.setTextColor(resources.getColor(R.color.color_true))
                    binding.rb2.setTextColor(resources.getColor(R.color.color_false))
                    binding.rb1.setTextColor(resources.getColor(R.color.color_false))
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE

                }
            }
        })
    }
}