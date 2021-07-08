package com.vietis.themovies.util.context

import android.content.Context
import android.widget.Toast
import java.lang.Exception

fun Context.showToast(obj: Any) {
    val msg = when (obj) {
        is Int -> getString(obj)
        is Exception -> obj.message.toString()
        else -> obj.toString()
    }
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}