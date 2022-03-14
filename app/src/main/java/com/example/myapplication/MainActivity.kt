package com.example.myapplication
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener{view->
            ClickDatePicker(view)

        }
        }
    fun ClickDatePicker(view: View){
        val myCalendar= Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,
        selyear,
        selmonth,
        seldayOfMonth ->Toast.makeText(this,"The Choosen Year $selyear, The choosen month ${selmonth+1}, "+
            "the day is $seldayOfMonth" ,Toast.LENGTH_LONG).show()
            val selectedDate="$seldayOfMonth/${selmonth+1}/$selyear"
            tvSelectedDate.setText(selectedDate)
            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate=sdf.parse(selectedDate)
            val selectedDateInMinutes=theDate!!.time/60000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time/60000
            val diffInMinutes=currentDateInMinutes-selectedDateInMinutes;
            tvDateInMinutes.setText(diffInMinutes.toString())

        },year,month,day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }
}