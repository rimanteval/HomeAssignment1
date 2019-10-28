package com.example.homeassignment1

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MyCursorAdapter(val context: Context, cursor: Cursor) : CursorAdapter(context, cursor, true),
    View.OnClickListener {
    lateinit var nimi: String
    override fun onClick(view: View?) {
        nimi = view?.findViewById<TextView>(R.id.name)?.text as String
        val intent = Intent(context, Main2Activity::class.java)
        intent.putExtra("name", nimi)
        //startActivity(intent) //why isn't this working? because its a cursoradapter class?
        Log.d("MA", nimi)
    }

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.custom_contact_list, parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        val body = cursor?.getString(cursor.getColumnIndexOrThrow("display_name"))
        view?.findViewById<TextView>(R.id.name)?.setOnClickListener(this)
        view?.findViewById<TextView>(R.id.name)?.text = body
    }

}
