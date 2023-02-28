package com.haruta.harutyan.memo

import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.haruta.harutyan.memo.databinding.ActivityEditBinding
import com.haruta.harutyan.memo.databinding.ActivityMainBinding
import org.json.JSONArray

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences("SharePref", Context.MODE_PRIVATE)
        val arrayList: ArrayList<String> = ArrayList()

        binding.saveButton.setOnClickListener {
            //保存された文字列を取り出す
            val str = pref.getString("MemoArray", "")
            //彼らをにJSONArrayに変換してあげる
            val jsonArray = JSONArray(str)
            //その配列をarrayListに入れる
            for (i in 0 until jsonArray.length()) {
                arrayList.add(jsonArray[i].toString())
            }
            //editTextを取得する
            val stringText = binding.editText.text.toString()
            //arrayListに追加する
            arrayList.add(stringText)
            //まとめて保存する
            val editor = pref.edit()
            editor.putString("MemoArray", arrayList.toString())
            editor.apply()

            finish()
            Log.d(
                "あああ",jsonArray.toString()
            )
        }

    }
}