package ru.geekbrains.closeapp

import android.app.Application
import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class GeekBrainsApp : Application() {

    companion object {
        lateinit var instance : GeekBrainsApp
    }

    private val cicerone : Cicerone<Router> by lazy { Cicerone.create() }

    val navigationHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
        RxJavaPlugins.setErrorHandler {
            if (it is UndeliverableException) {
                Log.e("1", it.message.toString())
            }
        }
    }
}