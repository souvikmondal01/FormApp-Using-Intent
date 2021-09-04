package com.example.formapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// DropDown Menu In Code:
        val genderOptions = resources.getStringArray(R.array.gender)
// OR    val genderOptions = listOf("Male","Female","Other")
        val adapterGender = ArrayAdapter(this, R.layout.list_item, genderOptions)
        tf_gender.setAdapter(adapterGender)

        val stateOptions = resources.getStringArray(R.array.states)
        val adapterStates = ArrayAdapter(this, R.layout.list_item, stateOptions)
        tf_state.setAdapter(adapterStates)

        btn_submit.setOnClickListener {
            if (cb_confirm.isChecked) {
                passData()
            }
        }

        tf_birth_day.setOnClickListener { datePicker() }

    }

    private fun datePicker() {

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, { _, year, month, dayOfMonth ->
            var monthInput = (month + 1).toString()
            when {
                monthInput.toInt() == 1 -> monthInput = "Jan"
                monthInput.toInt() == 2 -> monthInput = "Feb"
                monthInput.toInt() == 3 -> monthInput = "March"
                monthInput.toInt() == 4 -> monthInput = "April"
                monthInput.toInt() == 5 -> monthInput = "May"
                monthInput.toInt() == 6 -> monthInput = "June"
                monthInput.toInt() == 7 -> monthInput = "July"
                monthInput.toInt() == 8 -> monthInput = "Aug"
                monthInput.toInt() == 9 -> monthInput = "Sept"
                monthInput.toInt() == 10 -> monthInput = "Oct"
                monthInput.toInt() == 11 -> monthInput = "Nov"
                monthInput.toInt() == 12 -> monthInput = "Dec"
            }
            tf_birth_day.setText("$dayOfMonth $monthInput, $year ")
        }, year, month, day).show()
    }

    private fun passData() {
        val name = tf_name.editableText.toString()
        val phone = tf_phone.editableText.toString()
        val address = tf_address.editableText.toString()
        val city = tf_city.editableText.toString()
        val state = tf_state.editableText.toString()
        val pin = tf_pin.editableText.toString()
        val email = tf_mail.editableText.toString()
        val birthday = tf_birth_day.editableText.toString()
        val gender = tf_gender.text.toString()

        val intent = Intent(this, FormInformation::class.java)
        intent.putExtra("name", name)
        intent.putExtra("phone", phone)
        intent.putExtra("address", address)
        intent.putExtra("city", city)
        intent.putExtra("state", state)
        intent.putExtra("pin", pin)
        intent.putExtra("email", email)
        intent.putExtra("birthday", birthday)
        intent.putExtra("gender", gender)

        startActivity(intent)
    }
}