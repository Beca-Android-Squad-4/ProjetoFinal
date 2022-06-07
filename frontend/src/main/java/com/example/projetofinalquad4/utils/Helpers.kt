package com.example.projetofinalquad4.utils

import android.content.Context
import android.widget.Toast
import com.example.projetofinalquad4.view.viewModel.MainViewModelFactory
import com.nttdata.test.backend.data.remote.ICoinsClient
import com.nttdata.test.backend.data.remote.dto.CoinItem
import com.nttdata.test.backend.data.repository.CoinsRepository
import com.nttdata.test.backend.networkUtils.RetrofitInstance
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class Helpers {

    companion object {
        fun ToastText(text: String, context: Context) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        fun FilterListQuery(text: String?, list: List<CoinItem>): MutableList<CoinItem> {
            var newList: MutableList<CoinItem> = ArrayList()
            list.forEach {
                if (it.asset_id.contains(text.toString(), true)
                    or it.name.contains(text.toString(), false)
                ) {
                    newList.add(it)
                }
            }
            return newList
        }

        fun getCalendarDate(): String {
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
                current.format(formatter)
            } else {
                SimpleDateFormat("d MMM yyyy", Locale("pt-BR", "Brazil", "")).format(Date())
            }
        }

        fun getMainViewModelFactory(): MainViewModelFactory {
            val coinsClient: ICoinsClient by lazy {
                RetrofitInstance.get().create(ICoinsClient::class.java)
            }
            val coinsRepository = CoinsRepository(coinsClient)
            return MainViewModelFactory(coinsRepository)
        }

        fun formatPriceCoin(price: Double): String {
            return if (price < 100 && price >= 10) {
                val dec = DecimalFormat("00.#####")
                "$ " + dec.format(price)
            } else if (price < 10) {
                val dec = DecimalFormat("0.######")
                "$ " + dec.format(price)
            } else if (price.equals(0)) {
                "Sem Preço"
            } else if (price > 9999999) {
                val dec = DecimalFormat("##,###,###")
                var result = "$ " + dec.format(price)
                result
            } else {
                val dec = DecimalFormat("##,###.##")
                "$ " + dec.format(price)
            }
        }

        fun formatPriceVolumeHoraCoin(price: Double): String {
            // val teste = ((price / 10000000000000) * 1000) * 1000
            val dec = DecimalFormat("##,###.##")
            // return String.format("$ %.2f", price)
            return dec.format(price)
        }

        fun formatPriceVolumeDiaCoin(price: Double): String {
            // val teste = ((price / 1000000000000000) * 1000) * 1000
            val dec = DecimalFormat("##,###.##")
            // return String.format("$ %.2f", price)
            return dec.format(price)
        }

        fun formatPriceVolumeMesCoin(price: Double): String {
            // val teste = ((price / 1000000000000000000) * 100) * 1000
            val dec = DecimalFormat("##,###.##")
            // return String.format("$ %.2f", price)
            return dec.format(price)
        }
    }
}
