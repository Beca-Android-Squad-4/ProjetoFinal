package com.example.projetofinalquad4.utils

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

class Helpers {

    companion object {

        fun FilterListQuery(text: String?, list: List<CoinItem>): MutableList<CoinItem> {
            var newList: MutableList<CoinItem> = ArrayList()
            list.forEach {
                if (it.asset_id.contains(text.toString(), true)
                    or it.name.contains(text.toString(), true)
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
                val dec = DecimalFormat("######.##")
                var result = "$ " + dec.format(price)
                result
            } else {
                val dec = DecimalFormat("##,###.##")
                "$ " + dec.format(price)
            }
        }
    }
}
