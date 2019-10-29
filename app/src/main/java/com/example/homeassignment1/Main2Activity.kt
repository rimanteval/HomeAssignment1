package com.example.homeassignment1


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val nameTextView: TextView = findViewById(R.id.name_id)
        val numberTextView: TextView = findViewById(R.id.number_id)
        val emailTextView: TextView = findViewById(R.id.email_id)
        val mailTitle: EditText = findViewById(R.id.title)
        val mailMessage: EditText = findViewById(R.id.message)

        nameTextView.text = name
        numberTextView.text = number
        val name1 = name.replace(" ", "")
        emailTextView.text = "$name1@gmail.com"

        val intent = Intent(this, MainActivity::class.java)

        button.setOnClickListener {
            intent.putExtra("title", mailTitle.text.toString())
            intent.putExtra("message", mailMessage.text.toString())
            startActivity(intent)
        }

        button2.setOnClickListener {
            startActivity(intent)
        }


    }
}