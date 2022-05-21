package com.example.projetofinalquad4.utils

import android.content.Context
import android.widget.Toast
import com.example.projetofinalquad4.data.remote.dto.CoinDto

class Helpers {

    companion object {
        fun ToastText(text: String, context: Context) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        fun FilterListQuery(text: String?): MutableList<CoinDto> {
            var list: MutableList<CoinDto> = ArrayList()
            list.forEach {
                if (it.name.contains(text.toString(), true)
                    or it.symbol.contains(text.toString(), false)
                ) {
                    list.add(it)
                }
            }
            return list
        }
    }
}
