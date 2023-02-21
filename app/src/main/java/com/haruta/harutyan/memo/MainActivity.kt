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
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val editIntent: Intent = Intent(this, EditActivity::class.java)

        binding.actionButton.setOnClickListener {
            startActivity(editIntent)
        }

    }

    override fun onStart() {
        super.onStart()
        val arrayList: ArrayList<String> = ArrayList()

        val pref: SharedPreferences = getSharedPreferences("SharePref", Context.MODE_PRIVATE)

        //保存された文字列を取り出す
        val str = pref.getString("MemoArray", "")
        //彼らをにJSONArrayに変換してあげる
        val jsonArray = JSONArray(str)
        //その配列をarrayListに入れる
        for (i in 0 until jsonArray.length()) {
            arrayList.add(jsonArray[i].toString())
        }
        //その配列をListViewに表示する
        val list = findViewById<ListView>(R.id.memo_list)
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        //list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, JSONArray(str))

    }

    override fun onStop() {
        super.onStop()

    }

}