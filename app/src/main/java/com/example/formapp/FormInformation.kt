package com.example.formapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form_information.*

class FormInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_information)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        val state = intent.getStringExtra("state")
        val pin = intent.getStringExtra("pin")
        val email = intent.getStringExtra("email")
        val birthday = intent.getStringExtra("birthday")
        val gender = intent.getStringExtra("gender")

        tv_name.text = name
        tv_phone.text = phone
        tv_address.text = address
        tv_city.text = city
        tv_state.text = state
        tv_pin.text = pin
        tv_mail.text = email
        tv_birthday.text = birthday
        tv_gender.text = gender
    }
}