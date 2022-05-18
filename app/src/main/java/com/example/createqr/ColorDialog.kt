package com.bazooka.write_diary.ui.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MotionEvent
import com.example.createqr.databinding.DialogColorPikerBinding

class ColorDialog(context: Context, private val onClickChoose: (Int) -> Unit) :
    Dialog(context) {
    init {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private lateinit var binding: DialogColorPikerBinding
    private lateinit var bitmap: Bitmap

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogColorPikerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pixels: Int = 0
        binding.imgColorPiker.apply {
            setDrawingCacheEnabled(true)
            buildDrawingCache(true)
            setOnTouchListener { view, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_DOWN || motionEvent.action == MotionEvent.ACTION_MOVE) {
                    bitmap = this.drawingCache
                    pixels = bitmap.getPixel(motionEvent.x.toInt(), motionEvent.y.toInt())
                    val r = Color.red(pixels)
                    val g = Color.green(pixels)
                    val b = Color.blue(pixels)
                    binding.vColor.setBackgroundColor(Color.rgb(r, g, b))
                }
                return@setOnTouchListener true
            }

        }
        binding.tvCanCelColor.setOnClickListener {
            dismiss()
        }
        binding.tvChoose.setOnClickListener {
            dismiss()
            onClickChoose(pixels)
        }


    }
}