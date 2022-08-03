package ru.geekbrains.closeapp

import android.view.View

class CountersPresenter(
    private val view : MainView
    ) {

    private val model = CountersModel()

    fun onCounterClick(id: Int) {
        when(id) {
            R.id.btnButton1 -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnButton2 -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnButton3 -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }

}