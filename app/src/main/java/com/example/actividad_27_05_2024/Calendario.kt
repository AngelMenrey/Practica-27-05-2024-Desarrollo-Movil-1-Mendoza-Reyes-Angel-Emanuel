package com.example.actividad_27_05_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextClock
import android.widget.TextView
import java.util.Calendar

private lateinit var calendario: CalendarView
private lateinit var reloj: TextClock
private lateinit var fecha: TextView

class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        calendario = findViewById(R.id.calendarView)
        reloj = findViewById(R.id.textClock)
        fecha = findViewById(R.id.textView2)

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            fecha.text = "Fecha: $date"
        }
        val fechaFija = Calendar.getInstance()
        fechaFija.set(2026, 5-1, 8)
        calendario.date = fechaFija.timeInMillis
        val d = calendario.firstDayOfWeek
        calendario.firstDayOfWeek = (d+1) % 7
    }
}