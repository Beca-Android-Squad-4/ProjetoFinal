package com.example.projetofinalquad4.utils

import android.content.Context
import android.widget.Toast
import com.example.projetofinalquad4.data.remote.dto.CoinItem
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Helpers {

    companion object {
        fun ToastText(text: String, context: Context) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        // fun FilterListQuery(text: String?, list: List<CoinDto>): MutableList<CoinDto> {
        fun FilterListQuery(text: String?, list: List<CoinItem>): MutableList<CoinItem> {
            // var newList: MutableList<CoinDto> = ArrayList()
            var newList: MutableList<CoinItem> = ArrayList()
            list.forEach {
                if (it.asset_id.contains(text.toString(), true)
                    // or it.symbol.contains(text.toString(), false)
                    or it.name.contains(text.toString(), false)
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
