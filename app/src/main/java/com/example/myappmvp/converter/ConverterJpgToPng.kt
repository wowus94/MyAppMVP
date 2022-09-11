package com.example.myappmvp.converter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import io.reactivex.rxjava3.core.Single
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

class ConverterJpgToPng(val currentContext: Context) {


    fun convert(uri: Uri): Single<Uri> {
        val tempConvertedFile = File.createTempFile("tmpConvert", ".png")
        uri.let {
            val fos = FileOutputStream(tempConvertedFile)
            val bos = BufferedOutputStream(fos)
            val mim =
                ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(currentContext.contentResolver, it)
                )
            mim.compress(Bitmap.CompressFormat.PNG, 100, bos)
            bos.close()
            fos.close()
        }
        return Single.error(Throwable())
    }

}