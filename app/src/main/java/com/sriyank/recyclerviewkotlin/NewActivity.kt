package com.sriyank.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        intent.extras?.let { image_view.setImageResource(it.getInt("image")) }
        head.text = intent.getStringExtra("head")
        body.text = intent.getStringExtra("body")


    }
}