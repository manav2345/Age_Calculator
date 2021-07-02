package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get reference to button
        val bt1 = findViewById<Button>(R.id.bt1)
        val bt2 = findViewById<Button>(R.id.bt2)
        val tf1 = findViewById<TextView>(R.id.Tf1)
        val myCalender=Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val date=myCalender.get(Calendar.DATE)
        bt1.setText("$date/$month/$year")
        bt1.setOnClickListener {
            Toast.makeText(this@MainActivity, "bt1", Toast.LENGTH_SHORT).show()
            DatePickerDialog(this@MainActivity,
                DatePickerDialog.OnDateSetListener {
                        datePicker, Iyear, Imonth, Idate ->bt1.setText("$date/$month/$year")
                },year, month, date).show()
        }
        bt2.setOnClickListener {
            Toast.makeText(this@MainActivity, "bt2", Toast.LENGTH_SHORT).show()
            DatePickerDialog(this@MainActivity,
                DatePickerDialog.OnDateSetListener {
                        datePicker, Iyear, Imonth, Idate ->//bt2.setText("$Idate/$Imonth/$Iyear"
                    tf1.text = "${year-Iyear}Years" +
                            " ${month - Imonth}Months " +
                            "and ${date - Idate}Days old"
                },year, month, date).show()
        }
        }
    }
