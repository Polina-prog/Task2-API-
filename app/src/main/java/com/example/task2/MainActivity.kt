package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var url = ""
    var exp = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val btn1 = findViewById<Button>(R.id.btn1)
        val img1 = findViewById<ImageView>(R.id.img1)
        val txt1 = findViewById<TextView>(R.id.txt1)
        image()
        text()
        btn1.setOnClickListener{
            Picasso.get().load(url).into(img1)
            txt1.setText(exp)
            Log.d("MyLog1", exp)
        }
    }

    fun image()= runBlocking {
        GlobalScope.launch{
            url = RetrofitClient().service.getImage("Wo32R1UzAbnZD694PAU5O4g46ZPRjPt2oXw3a7iG")?.body()?.url!!
        }
    }

    fun text()= runBlocking {
        GlobalScope.launch{
            exp = RetrofitClient().service.getImage("Wo32R1UzAbnZD694PAU5O4g46ZPRjPt2oXw3a7iG")?.body()?.explanation!!
        }
    }
}