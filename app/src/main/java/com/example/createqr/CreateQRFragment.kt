package com.example.createqr

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.bazooka.write_diary.ui.dialog.ColorDialog
import com.bumptech.glide.Glide
import com.example.createqr.databinding.FragmentCreateQrBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix


class CreateQRFragment : Fragment() {
    private lateinit var binding: FragmentCreateQrBinding
    private lateinit var colorPiker : ColorDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateQrBinding.inflate(inflater, container, false)

        binding.btnCreateQR.setOnClickListener {
            //onClick()
        }
        binding.btnColor.setOnClickListener {
            colorPiker = ColorDialog(requireContext(),onClickChoose = onClickChoose())
            colorPiker.show()
        }

        return binding.root
    }
    private fun onClickChoose(): (Int) -> Unit = { color ->
        val r = Color.red(color)
        val g = Color.green(color)
        val b = Color.blue(color)
        onClick(color)
    }

    private fun onClick(color : Int) {
        var bitmap  = encode(binding.edtText.text.toString(),400,400,color,-16711936)
        Glide.with(requireActivity()).load(bitmap).into(binding.imgQR)
    }



    private fun encode(
        contents: String,
        width: Int,
        height: Int,
        @ColorInt foreground: Int,
        @ColorInt background: Int
    ): Bitmap? {
        val writer = MultiFormatWriter()
        var matrix: BitMatrix? = null
        var bitmap: Bitmap? = null
        try {
            matrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        if (matrix != null) {
            val pixels = IntArray(width * height)
            for (y in 0 until height) {
                val offset = y * width
                for (x in 0 until width) {
                    pixels[offset + x] = if (matrix[x, y]) foreground else background
                }
            }
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        }
        return bitmap
    }


}