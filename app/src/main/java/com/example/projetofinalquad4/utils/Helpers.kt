package com.example.projetofinalquad4.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projetofinalquad4.data.remote.dto.CoinDto

class Helpers {

    companion object {
        fun ToastText(text: String, context: Context) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        fun FilterListQuery(text: String?, list: List<CoinDto>): MutableList<CoinDto> {
            var newList: MutableList<CoinDto> = ArrayList()
            list.forEach {
                if (it.name.contains(text.toString(), true)
                    or it.symbol.contains(text.toString(), false)
                ) {
                    newList.add(it)
                }
            }
            return newList
        }

//        fun replaceFragment(fragment: Fragment){
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(binding.navFragment.id, fragment)
//            fragmentTransaction.commit()
//        }
    }
}
