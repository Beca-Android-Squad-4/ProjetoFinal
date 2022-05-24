package com.example.projetofinalquad4.utils

import android.content.Context
import android.widget.Toast
import com.example.projetofinalquad4.data.remote.dto.CoinDto
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Helpers {

    companion object {
        fun ToastText(text: String, context: Context) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        fun FilterListQuery(text: String?, list: List<CoinDto>): MutableList<CoinDto> {
            var newList: MutableList<CoinDto> = ArrayList()
            list.forEach {
                if (it.name.contains(text.toString(), true)
                    // or it.symbol.contains(text.toString(), false)
                    or it.icon.contains(text.toString(), false)
                ) {
                    newList.add(it)
                }
            }
            return newList
        }

        fun GetCalendarDate(): String {
            // val currentTime: Date = Calendar.getInstance().getTime()

            return SimpleDateFormat("d MMM yyyy", Locale.getDefault()).format(Date())
        }

//        fun replaceFragment(fragment: Fragment){
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(binding.navFragment.id, fragment)
//            fragmentTransaction.commit()
//        }
    }
}
