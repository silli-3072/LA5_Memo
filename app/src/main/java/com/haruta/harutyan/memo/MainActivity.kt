package com.haruta.harutyan.memo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.haruta.harutyan.memo.databinding.ActivityEditBinding
import com.haruta.harutyan.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //val array = listOf<String>("リスト１","リスト２","リスト３")
        //val list = findViewById<ListView>(R.id.memo_list)

        //list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)

        val editIntent: Intent = Intent(this, EditActivity::class.java)

        binding.actionButton.setOnClickListener {
            startActivity(editIntent)
        }

    }

    override fun onStart() {
        super.onStart()

        val pref: SharedPreferences = getSharedPreferences("SharePref", Context.MODE_PRIVATE)
        val str = pref.getString("MemoArray", "")

        val list = findViewById<ListView>(R.id.memo_list)

        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, str)

    }

    override fun onStop() {
        super.onStop()

    }

}