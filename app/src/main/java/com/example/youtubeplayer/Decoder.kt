package com.example.youtubeplayer

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class Decoder {

    @RequiresApi(Build.VERSION_CODES.O)
    fun decodeKey(key: String): String {
        val decidedBytes = Base64.getDecoder().decode(key)

        return String(decidedBytes)
    }
}