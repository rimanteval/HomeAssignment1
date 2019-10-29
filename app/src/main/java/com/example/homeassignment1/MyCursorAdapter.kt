package com.example.homeassignment1

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MyCursorAdapter(private val context: Context, cursor: Cursor) :
    CursorAdapter(context, cursor, true),
    View.OnClickListener {
    private val nameMap: MutableMap<String, String> = mutableMapOf()
    override fun onClick(view: View?) {
        val nimi = view?.findViewById<TextView>(R.id.name)?.text as String
        val numb = nameMap[nimi]
        val intent = Intent(context, Main2Activity::class.java)
        intent.putExtra("name", nimi)
        intent.putExtra("number", numb)
        val bundle = intent.extras
        startActivity(
            context,
            intent,
            bundle
        )

    }

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.custom_contact_list, parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        val body =
            cursor?.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
        val num =
            cursor?.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
        nameMap[body.toString()] = num.toString()
        view?.findViewById<TextView>(R.id.name)?.setOnClickListener(this)
        view?.findViewById<TextView>(R.id.name)?.text = body
        view?.findViewById<TextView>(R.id.number)?.text = num.toString()
    }

}
