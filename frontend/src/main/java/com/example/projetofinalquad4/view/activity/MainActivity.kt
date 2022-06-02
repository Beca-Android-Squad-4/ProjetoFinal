package com.example.projetofinalquad4.view.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projetofinalquad4.R
import com.example.projetofinalquad4.databinding.ActivityMainBinding
import com.example.projetofinalquad4.view.fragment.CoinsFragment
import com.example.projetofinalquad4.view.fragment.FavoritesFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        if (savedInstanceState == null) {
            replaceFragment(CoinsFragment())
        }

        // NavigationBarView(https://m3.material.io/components/navigation-bar/implementation/android) é mais indicada para essa funcionalidade,
        // Mas como o intuito do projeto é deixar o mais fiel possivel ao desafio proposto
        // a BottomNavigationView será usada *****POR ENQUANTO******
        // TODO implementar NavigationBar em forma de BottonNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_moedas -> {
                    replaceFragment(CoinsFragment())
                    true
                }
                R.id.nav_favoritos -> {
                    replaceFragment(FavoritesFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.navFragment.id, fragment)
        fragmentTransaction.commit()
    }
}
