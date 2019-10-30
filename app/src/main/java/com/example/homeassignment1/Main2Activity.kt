package com.example.homeassignment1


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri.fromParts
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
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
        emailTextView.text = "$name1@mail.io"

        button.setOnClickListener {
            val emailIntent = Intent(
                Intent.ACTION_SENDTO, fromParts(
                    "mailto", "$name1@mail.io", null
                )
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailTitle.text.toString())
            emailIntent.putExtra(Intent.EXTRA_TEXT, mailMessage.text.toString())
            startActivityForResult(Intent.createChooser(emailIntent, "Send email..."), 800)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 800) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}