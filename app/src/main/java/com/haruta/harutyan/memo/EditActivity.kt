package com.haruta.harutyan.memo

import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haruta.harutyan.memo.databinding.ActivityEditBinding
import com.haruta.harutyan.memo.databinding.ActivityMainBinding
import org.json.JSONArray

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences("SharePref", Context.MODE_PRIVATE)

        binding.saveButton.setOnClickListener {
            val arrayList: ArrayList<String> = ArrayList()

            val stringText = binding.editText.text.toString()

            val editor = pref.edit()
            //editor.putString("Memo", stringText)
            //editor.apply()

            val jsonArray = JSONArray(arrayList)
            editor.putString("MemoArray", jsonArray.toString())
            editor.apply()

            finish()
        }

    }
}