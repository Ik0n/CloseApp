package ru.geekbrains.closeapp.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.closeapp.GeekBrainsApp
import ru.geekbrains.closeapp.R
import ru.geekbrains.closeapp.core.OnBackPressedListener
import ru.geekbrains.closeapp.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.containerMain)
    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(GeekBrainsApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        GeekBrainsApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        GeekBrainsApp.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }
}