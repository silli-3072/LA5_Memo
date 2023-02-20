package com.haruta.harutyan.memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haruta.harutyan.memo.databinding.ActivityEditBinding
import com.haruta.harutyan.memo.databinding.ActivityMainBinding

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
}