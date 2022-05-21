package com.example.projetofinalquad4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projetofinalquad4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(MoedasFragment())
        }

        // NavigationBarView(https://m3.material.io/components/navigation-bar/implementation/android) é mais indicada para essa funcionalidade,
        // Mas como o intuito do projeto é deixar o mais fiel possivel ao desafio proposto
        // a BottomNavigationView será usada *****POR ENQUANTO******
        // TODO implementar NavigationBar em forma de BottonNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_moedas -> {
                    replaceFragment(MoedasFragment())
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

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.navFragment.id,fragment)
        fragmentTransaction.commit()
    }
}
