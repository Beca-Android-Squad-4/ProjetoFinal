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

        fun GetCalendarDate(): String {
            return SimpleDateFormat("d MMM yyyy", Locale.getDefault()).format(Date())
        }

        fun getMainViewModelFactory(): MainViewModelFactory {
            val coinsClient: ICoinsClient by lazy {
                RetrofitInstance.get().create(ICoinsClient::class.java)
            }
            val coinsRepository = CoinsRepository(coinsClient)
            return MainViewModelFactory(coinsRepository)
        }

        fun formatPriceCoin(price: Double): String {
            val dec = DecimalFormat("00,000.00")
            return dec.format(price)
        }

        fun formatPriceVolumeHoraCoin(price: Double): String {
            val teste = ((price / 10000000000000) * 1000) * 1000
            val dec = DecimalFormat("###,000.00")
            // return String.format("$ %.2f", price)
            return dec.format(teste)
        }

        fun formatPriceVolumeDiaCoin(price: Double): String {
            val teste = ((price / 1000000000000000) * 1000) * 1000
            val dec = DecimalFormat("###,000.00")
            // return String.format("$ %.2f", price)
            return dec.format(teste)
        }

        fun formatPriceVolumeMesCoin(price: Double): String {
            val teste = ((price / 1000000000000000000) * 100) * 1000
            val dec = DecimalFormat("###,000.00")
            // return String.format("$ %.2f", price)
            return dec.format(teste)
        }
    }
}
