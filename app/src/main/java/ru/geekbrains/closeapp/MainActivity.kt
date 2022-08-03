package ru.geekbrains.closeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.closeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAll()
    }

    private fun initAll() {
        initButtonsClick()
        initPresenter()
        setButtonsLabels(presenter.getCounters())
    }

    private fun initButtonsClick() {
        with(binding) {
            this.btnButton1.setOnClickListener {
                presenter.onCounterClick(FIRST_BUTTON)
            }
            this.btnButton2.setOnClickListener {
                presenter.onCounterClick(SECOND_BUTTON)
            }
            this.btnButton3.setOnClickListener {
                presenter.onCounterClick(THIRD_BUTTON)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when(position) {
                FIRST_BUTTON -> this.tvText1.text = counter
                SECOND_BUTTON -> this.tvText2.text = counter
                THIRD_BUTTON -> this.tvText3.text = counter
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(COUNTERS, presenter.getCounters().toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getIntArray(COUNTERS)?.toMutableList()?.let { counters ->
            presenter.getCounters().clear()
            presenter.getCounters().addAll(counters)
            setButtonsLabels(presenter.getCounters())
        }
    }

    private fun setButtonsLabels(counters : MutableList<Int>) {
        with(binding) {
            this.tvText1.text = counters[0].toString()
            this.tvText2.text = counters[1].toString()
            this.tvText3.text = counters[2].toString()
        }
    }

}