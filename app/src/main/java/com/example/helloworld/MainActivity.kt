package com.example.helloworld

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(){ view ->
            displayDates(view)
        }

        }
    fun displayDates(view: View){
        val tv1: TextView = findViewById(R.id.TextView4)
        val tv2: TextView = findViewById(R.id.TextView6)
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get((Calendar.DAY_OF_MONTH))
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view,selectedYear, selectedMonth,selectedDay -> val selectedDate = "$selectedDay/${selectedMonth +1}/$selectedYear"

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val ageInMins = (myCalender.timeInMillis - theDate.time) /60000
            tv1.setText(selectedDate)
            tv2.setText(ageInMins.toString())                                                     }
            ,year,month,day).show()

    }
    }
