package com.example.actividad_27_05_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.SeekBar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class Barras : AppCompatActivity() {

    private lateinit var barra: ProgressBar
    private lateinit var barra2: ProgressBar
    private lateinit var barra3: SeekBar
    private lateinit var barraRating: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barras)

        barra = findViewById(R.id.progressBar)
        barra2 = findViewById(R.id.progressBar2)
        barra3 = findViewById(R.id.seekBar)
        barraRating = findViewById(R.id.ratingBar)

        barra.max = 100
        barra2.max = 100
        barra3.max = 100
        barraRating.numStars = 5

        GlobalScope.launch {
            administrarProgressBar(barra, 5, 10)
            administrarProgressBar(barra2, 2, 5)
            administrarSeekBar(barra3)
        }

        barra3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                barraRating.rating = i.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        barraRating.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            barra3.progress = rating.toInt()
        }
    }

    private suspend fun administrarProgressBar(barra: ProgressBar, incrementProgress: Int, incrementSecondaryProgress: Int) {
        while (barra.progress < barra.max) {
            barra.progress += incrementProgress
            barra.secondaryProgress += incrementSecondaryProgress
            delay(100L)
        }
    }

    private suspend fun administrarSeekBar(barra: SeekBar) {
        while (true) {
            barra.incrementProgressBy(5)
            delay(100L)
        }
    }
}
