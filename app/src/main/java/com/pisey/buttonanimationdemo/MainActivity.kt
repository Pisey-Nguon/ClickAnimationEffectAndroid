package com.pisey.buttonanimationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pisey.button_animation.DoubleClick
import com.pisey.button_animation.setOnDoubleClickListener
import com.pisey.button_animation.setOnSingleClickListener

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt1 = findViewById<TextView>(R.id.bt1)
        val bt2 = findViewById<TextView>(R.id.bt2)
        val bt3 = findViewById<TextView>(R.id.bt3)
        val bt4 = findViewById<TextView>(R.id.bt4)

        bt1.setOnSingleClickListener {
            Log.d(TAG, "onClick: button 1")
        }
        bt2.setOnSingleClickListener(colorFilter = ContextCompat.getColor(this,R.color.purple_200)){
            Log.d(TAG, "onClick: button 2")
        }
        bt3.setOnSingleClickListener(colorFilter = ContextCompat.getColor(this,R.color.purple_200), isAnimate = true){
            Log.d(TAG, "onClick: button 3")
        }
        bt4.setOnDoubleClickListener(object:DoubleClick.DoubleClickListener{
            override fun onDoubleClick() {
                Log.d(TAG, "onDoubleClick")
            }

            override fun onSingleClick() {
                Log.d(TAG, "onSingleClick")
            }

        })


    }
}