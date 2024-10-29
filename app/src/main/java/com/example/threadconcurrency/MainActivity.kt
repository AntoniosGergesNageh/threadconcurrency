package com.example.threadconcurrency

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val countdownHandler = Handler(Looper.getMainLooper()){
        countDownTextView.text =it.what.toString()

        true
    }
    val countDownTextView: TextView by lazy {
        findViewById(R.id.countdownTextview)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    val t=Thread{

            repeat(100){
                    i->
                Log.d("Countdown",(100 -i).toString())
               // countDownTextView.text =(100 -i).toString()
                //val message= Message.obtain()

                //message.what= 100-i
                //countdownHandler.sendMessage(message)
                countdownHandler.sendEmptyMessage(100-i)
                Thread.sleep(1000)
            }
        }

t.start()

    }
}