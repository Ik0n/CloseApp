package ru.geekbrains.closeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.geekbrains.closeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            this.btnButton1.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton1)
            }
            this.btnButton2.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton2)
            }
            this.btnButton3.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton3)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when(position) {
                0 -> this.tvText1.text = counter
                1 -> this.tvText2.text = counter
                2 -> this.tvText3.text = counter
            }
        }
    }

}